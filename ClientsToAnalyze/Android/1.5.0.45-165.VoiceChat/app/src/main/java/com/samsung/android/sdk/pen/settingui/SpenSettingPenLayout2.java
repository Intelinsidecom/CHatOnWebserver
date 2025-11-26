package com.samsung.android.sdk.pen.settingui;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
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
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.samsung.android.sdk.pen.pen.preload.Beautify;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import com.samsung.android.sdk.pen.settingui.SpenColorGradationView2;
import com.samsung.android.sdk.pen.settingui.SpenColorPaletteView2;
import com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter;
import com.samsung.android.sdk.pen.settingui.SpenScrollView;
import com.samsung.android.sdk.pen.util.SpenFont;
import com.sec.spp.push.Config;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
class SpenSettingPenLayout2 extends LinearLayout {
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
    private static final int BEAUTIFY_STYLEID_CURSIVE_LM = 11;
    private static final int BEAUTIFY_STYLEID_HUAI = 12;
    private static final int BEAUTIFY_STYLEID_HUANG = 5;
    private static final int BEAUTIFY_STYLEID_HUI = 6;
    private static final int BEAUTIFY_STYLEID_RUNNING_HAND_S = 1;
    private static final int BEAUTIFY_STYLEID_WANG = 3;
    protected static final int BOTTOM_LAYOUT_HEIGHT = 1;
    private static final String CHINESE_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.ChineseBrush";
    private static final String MAGIC_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.MagicPen";
    protected static final int MAXIMUM_PRESET_NUMBER = 36;
    private static final int MAX_PARAMETER_INDEX = 10;
    protected static final int PEN_SIZE_MAX = 99;
    private static final int REP_DELAY = 20;
    protected static final int SEEKBAR_LAYOUT_HEIGHT = 62;
    protected static final float SUITABLE_WIDTH_IN_ANIMATION_SCROLL = 55.0f;
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
    protected final int BEAUTIFY_RESET_BUTTON_HEIGHT;
    protected final int BODY_LAYOUT_HEIGHT;
    protected final int BODY_LAYOUT_HEIGHT_MAGIC_PEN;
    protected final int BODY_LAYOUT_HEIGHT_WITH_ALPHA;
    protected final int BODY_LAYOUT_WIDTH_BEAUTIFY_PEN;
    protected int EXIT_BUTTON_HEIGHT;
    protected final int EXIT_BUTTON_RAW_HEIGHT;
    protected final int EXIT_BUTTON_RAW_WIDTH;
    protected float EXIT_BUTTON_RIGHT_MARGIN;
    protected float EXIT_BUTTON_TOP_MARGIN;
    protected int EXIT_BUTTON_WIDTH;
    protected float LINE_BUTTON_HEIGHT;
    protected final int LINE_BUTTON_RAW_HEIGHT;
    protected final int LINE_BUTTON_RAW_WIDTH;
    protected float LINE_BUTTON_TOP_MARGIN;
    protected float LINE_BUTTON_WIDTH;
    private final int MAX_HEIGHT_FLAG;
    protected final int TITLE_LAYOUT_HEIGHT;
    protected final int TOTAL_LAYOUT_WIDTH;
    protected final int TYPE_SELECTOR_LAYOUT_HEIGHT;
    private Drawable alphaDrawable;
    private SpenColorPaletteView2 colorPaletteView;
    private int currenMagicPenHeight;
    private int currentOrtherPenHeight;
    private int deltaOfMiniMode;
    Handler handler;
    private final View.OnTouchListener horizontalScrollViewTouchListener;
    private boolean isMagicPenEnable;
    private boolean isMinimumMode;
    private boolean isPresetClicked;
    private RelativeLayout localPenTypeViewGroup;
    protected ActionListener mActionListener;
    private View mAdvancedSettingButton;
    private final View.OnClickListener mAdvancedSettingButtonListner;
    private final SpenPenInterface.ChangeListener mAdvancedSettingListener;
    private boolean mAdvancedSettingShow;
    private final SeekBar.OnSeekBarChangeListener mBeautifyAdvanceCursiveChangeListner;
    protected View mBeautifyAdvanceCursiveMinusButton;
    private final View.OnClickListener mBeautifyAdvanceCursiveMinusButtonListener;
    protected View mBeautifyAdvanceCursivePlusButton;
    private final View.OnClickListener mBeautifyAdvanceCursivePlusButtonListener;
    protected SeekBar mBeautifyAdvanceCursiveSeekbar;
    private final SeekBar.OnSeekBarChangeListener mBeautifyAdvanceDummyChangeListner;
    protected View mBeautifyAdvanceDummyMinusButton;
    private final View.OnClickListener mBeautifyAdvanceDummyMinusButtonListener;
    protected View mBeautifyAdvanceDummyPlusButton;
    private final View.OnClickListener mBeautifyAdvanceDummyPlusButtonListener;
    protected SeekBar mBeautifyAdvanceDummySeekbar;
    private final SeekBar.OnSeekBarChangeListener mBeautifyAdvanceModulationChangeListner;
    protected View mBeautifyAdvanceModulationMinusButton;
    private final View.OnClickListener mBeautifyAdvanceModulationMinusButtonListener;
    protected View mBeautifyAdvanceModulationPlusButton;
    private final View.OnClickListener mBeautifyAdvanceModulationPlusButtonListener;
    protected SeekBar mBeautifyAdvanceModulationSeekbar;
    protected Button mBeautifyAdvanceResetButton;
    private final View.OnClickListener mBeautifyAdvanceResetButtonListener;
    protected View mBeautifyAdvanceSettingLayout;
    private final SeekBar.OnSeekBarChangeListener mBeautifyAdvanceSustenanceChangeListner;
    protected View mBeautifyAdvanceSustenanceMinusButton;
    private final View.OnClickListener mBeautifyAdvanceSustenanceMinusButtonListener;
    protected View mBeautifyAdvanceSustenancePlusButton;
    private final View.OnClickListener mBeautifyAdvanceSustenancePlusButtonListener;
    protected SeekBar mBeautifyAdvanceSustenanceSeekbar;
    protected TextView mBeautifyCursiveTextView;
    protected TextView mBeautifyDummyTextView;
    protected View mBeautifyEnableLayout;
    protected Switch mBeautifyEnableSwitchView;
    protected TextView mBeautifyEnableTextView;
    private final CompoundButton.OnCheckedChangeListener mBeautifyEnablecheckedChangeListener;
    protected TextView mBeautifyModulationTextView;
    protected GradientDrawable mBeautifySeekbarColor;
    protected String mBeautifyStr;
    protected ArrayList<ImageButton> mBeautifyStyleBtnViews;
    protected View mBeautifyStyleBtnsLayout;
    private final View.OnClickListener mBeautifyStyleBtnsListener;
    protected TextView mBeautifySustenanceTextView;
    protected View mBodyBg;
    protected RelativeLayout mBodyLayout;
    protected RelativeLayout mBodyLayout2;
    protected int mBodyLayoutHeight;
    protected ImageView mBottomExtendBg;
    protected ImageView mBottomHandle;
    protected View mBottomLayout;
    protected RelativeLayout mCanvasLayout;
    protected int mCanvasSize;
    protected SpenSettingViewInterface mCanvasView;
    protected SpenColorGradationView2 mColorGradationView;
    protected SpenColorPaletteView2 mColorPaletteView;
    private final SpenColorGradationView2.onColorChangedListener mColorPickerColorChangeListener;
    protected View mColorPickerColorImage;
    protected View mColorPickerCurrentColor;
    private final View.OnClickListener mColorPickerCurrentColorListener;
    protected SpenColorPickerLayout2 mColorPickerSetting;
    protected View mColorPickerSettingExitButton;
    protected View mColorSelectPickerLayout;
    protected Context mContext;
    private int mCount;
    private int mCountForScrollPen;
    private final int[][] mCurrentBeautifyAdvanceSettingValues;
    private int mCurrentBeautifyStyle;
    protected SPenImageUtil mDrawableImg;
    private final View.OnClickListener mExitButtonListener;
    protected boolean mExpandFlag;
    protected boolean mExpend;
    View.OnTouchListener mExpendBarListener;
    protected boolean mFirstLongPress;
    protected boolean mFirstTimeColorPickerShow;
    private final Handler mHandler;
    private final Handler mHandlerForScrollPen;
    private SpenImageLoader mImageLoader;
    protected int mLeftMargin;
    protected View mLine1Button;
    protected View mLine2Button;
    protected Rect mMovableRect;
    int mNumberOfPenExist;
    private final SpenPenPresetListAdapter.OnClickPresetItemListener mOnClickPresetItemListener;
    private final SpenColorPaletteView2.OnColorChangedListener mOnColorChangedListener;
    private final View.OnHoverListener mOnConsumedHoverListener;
    private final View.OnTouchListener mOnConsumedTouchListener;
    protected View mOpacityMinusButton;
    protected View mOpacityPlusButton;
    private int mOrientation;
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
    private final View.OnClickListener mPenAlphaMinusButtonListener;
    private final View.OnLongClickListener mPenAlphaMinusButtonLongClickListener;
    private final View.OnTouchListener mPenAlphaMinusButtonTouchListener;
    private final View.OnClickListener mPenAlphaPlusButtonListener;
    private final View.OnLongClickListener mPenAlphaPlusButtonLongClickListener;
    private final View.OnTouchListener mPenAlphaPlusButtonTouchListener;
    protected RelativeLayout mPenAlphaPreview;
    protected SeekBar mPenAlphaSeekbar;
    protected GradientDrawable mPenAlphaSeekbarColor;
    protected View mPenAlphaSeekbarView;
    protected TextView mPenAlphaTextView;
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
    private final View.OnClickListener mPenSizeMinusButtonListener;
    private final View.OnLongClickListener mPenSizeMinusButtonLongClickListener;
    private final View.OnTouchListener mPenSizeMinusButtonTouchListener;
    protected View mPenSizePlusButton;
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
    protected ViewGroup mPenTypeLayout;
    private final View.OnClickListener mPenTypeListner;
    private final View.OnTouchListener mPenTypeTouchListener;
    protected ArrayList<View> mPenTypeView;
    protected View mPickerView;
    protected SpenPluginManager mPluginManager;
    private final View.OnClickListener mPopupButtonListener;
    private PopupListener mPopupListener;
    protected View mPopupMaxButton;
    protected View mPopupMinButton;
    protected int mPreCanvasFingerAction;
    protected int mPreCanvasPenAction;
    private final View.OnClickListener mPreSetAddButtonListner;
    protected View mPresetAddButton;
    protected List<SpenSettingPenInfo> mPresetDataList;
    protected GridView mPresetGridView;
    protected LinearLayout mPresetLayout;
    protected SpenPenPresetListAdapter mPresetListAdapter;
    protected PresetListener mPresetListener;
    protected TextView mPresetTextView;
    protected View mPreviewLayout;
    protected int mPreviousSelectedPresetIndex;
    private Timer mScrollTimer;
    private Timer mScrollTimerForScrollPen;
    protected SpenScrollView mScrollView;
    private final SpenScrollView.scrollChangedListener mScrollViewListner;
    protected int mScrollY;
    protected SpenSettingPenInfo mSettingInfo;
    protected SPenTextUtil mStringUtil;
    private boolean mSupportBeautifyPen;
    protected String mSustenanceStr;
    protected View mTitleLayout;
    protected int mTopMargin;
    protected int mTotalLeftMargin;
    protected int mTotalTopMargin;
    protected LinearLayout mTypeSelectorLayout;
    protected int mViewMode;
    protected int mWindowHeight;
    protected int mXDelta;
    protected int mYDelta;
    private RelativeLayout penTypeLayout;
    private boolean previousPenMagicSelected;
    private final Handler repeatUpdateHandler;
    private TextView titleTextView;
    protected static float mScale = 1.0f;
    protected static String mDefaultPath = "";
    private static boolean isHighlightPenRemoved = false;
    private static boolean isMagicPenRemoved = false;
    private static final int mSdkVersion = Build.VERSION.SDK_INT;
    protected static boolean mColorPickerShow = false;
    private static final String titleLeftPath = String.valueOf(mDefaultPath) + "vienna_popup_title_bg";
    private static final String popupMaxPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_max_normal";
    private static final String popupMinPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_min_normal";
    private static final String presetAddPath = String.valueOf(mDefaultPath) + "snote_popup_add";
    private static final String presetAddFocusPath = String.valueOf(mDefaultPath) + "snote_popup_add_focus";
    private static final String presetAddPressPath = String.valueOf(mDefaultPath) + "snote_popup_add_press";
    private static final String linePath = String.valueOf(mDefaultPath) + "snote_popup_divider";
    private static final String lineDivider = String.valueOf(mDefaultPath) + "snote_popup_line";
    private static final String lightBodyLeftPath = String.valueOf(mDefaultPath) + "vienna_popup_bg";
    private static final String grayBodyLeftPath = String.valueOf(mDefaultPath) + "vienna_popup_bg02";
    private static final String tabLinePath = String.valueOf(mDefaultPath) + "snote_page_num_bg";
    private static final String tabLineSelectPath = String.valueOf(mDefaultPath) + "snote_page_num_bg_press";
    private static final String tabLineFocusPath = String.valueOf(mDefaultPath) + "snote_page_num_bg_focus";
    protected static final String mPreviewBgPath = String.valueOf(mDefaultPath) + "snote_popup_preview_bg";
    private static final String leftBgPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_left_normal";
    private static final String lefBgPresslPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_left_press";
    private static final String lefBgFocuslPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_left_focus";
    private static final String rightBgPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_right_normal";
    private static final String rightBgPresslPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_right_press";
    private static final String rightBgFocuslPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_right_focus";
    private static final String plusBgPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_plus_normal";
    private static final String plusBgPressPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_plus_press";
    private static final String plusBgFocusPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_plus_focus";
    private static final String minusBgPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_minus_normal";
    private static final String minusBgPressPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_minus_press";
    private static final String minusBgFocusPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_minus_focus";
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
    private static final String bottomHandlePath = String.valueOf(mDefaultPath) + "snote_popup_handler";
    private static final String mImagePath_snote_add = String.valueOf(mDefaultPath) + "snote_add";
    private static final String mImagePath_snote_add_press = String.valueOf(mDefaultPath) + "snote_add_press";
    private static final String mImagePath_snote_add_dim = String.valueOf(mDefaultPath) + "snote_add_dim";
    private static final int[][] BEAUTIFY_ADVANCE_DEFAULT_SETTING_VALUES = {new int[]{11, 2, 5, 8, 1, 15, 70, 11, 0, 1}, new int[]{12, 2, 5, 1, 1, 18, 70, 13, 0, 1}, new int[]{5, 2, 2, 2, 1, 18, 70, 5, 0, 1}, new int[]{6, 2, 3, 3, 1, 12, 70, 6, 0, 1}, new int[]{1, 2, 2, 8, 1, 15, 70, 3, 0, 1}, new int[]{3, 1, 3, 5, 1, 12, 70, 1, 0, 1}};

    public interface ActionListener {
        void onMoved();

        void onResized();
    }

    public interface PopupListener {
        void onPopup(boolean z);
    }

    public interface PresetListener {
        void onAdded(SpenSettingPenInfo spenSettingPenInfo);

        void onDeleted(int i);

        void onSelected(int i);
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
    protected void onVisibilityChanged(View changedView, int visibility) {
        try {
            if (!isMagicPenRemoved) {
                for (int i = 0; i < this.mPenTypeView.size(); i++) {
                    if (this.mPenTypeView.get(i).isSelected() && this.mPenTypeView.get(i).getId() == 1005) {
                        setMagicPenMode(this.currenMagicPenHeight);
                        this.mPenAlphaPreview.setVisibility(0);
                        if (this.mPenAlphaSeekbar.getProgress() == 0) {
                            this.mPenAlphaTextView.setText("1%");
                            this.mPenAlphaTextView.setX(this.mDrawableImg.getIntValueAppliedDensity(45.0f));
                            this.mPenAlphaTextView.setY(this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                        }
                        this.handler.postDelayed(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.51
                            @Override // java.lang.Runnable
                            public void run() {
                                SpenSettingPenLayout2.this.alphaDrawable.setAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                            }
                        }, 200L);
                    }
                }
            }
        } catch (NullPointerException e) {
        }
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

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        try {
            this.mOrientation = newConfig.orientation;
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

    public void setLayoutHeight(int height) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
        params.height = height;
        setLayoutParams(params);
    }

    public void setPopupListenr(PopupListener listener) {
        if (listener != null) {
            this.mPopupListener = listener;
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
            if (!SpenSettingPenLayout2.this.mPenSizeAutoIncrement) {
                if (!SpenSettingPenLayout2.this.mPenSizeAutoDecrement) {
                    if (!SpenSettingPenLayout2.this.mPenAlphaAutoIncrement) {
                        if (SpenSettingPenLayout2.this.mPenAlphaAutoDecrement) {
                            SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(-1);
                            SpenSettingPenLayout2.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout2.this.new RptUpdater(), 20L);
                            return;
                        }
                        return;
                    }
                    SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(1);
                    SpenSettingPenLayout2.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout2.this.new RptUpdater(), 20L);
                    return;
                }
                SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(-1);
                float min = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    if (SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight()) {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth();
                    } else {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight();
                    }
                    if (SpenSettingPenLayout2.this.mCanvasSize == 0) {
                        SpenSettingPenLayout2.this.mCanvasSize = 1080;
                    }
                } else {
                    SpenSettingPenLayout2.this.mCanvasSize = 1080;
                }
                SpenSettingPenLayout2.this.mSettingInfo.size = (((SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout2.this.mCanvasSize) / 360.0f;
                SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                SpenSettingPenLayout2.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout2.this.new RptUpdater(), 20L);
                return;
            }
            SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(1);
            float min2 = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
            if (SpenSettingPenLayout2.this.mCanvasView != null) {
                if (SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight()) {
                    SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth();
                } else {
                    SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight();
                }
                if (SpenSettingPenLayout2.this.mCanvasSize == 0) {
                    SpenSettingPenLayout2.this.mCanvasSize = 1080;
                }
            } else {
                SpenSettingPenLayout2.this.mCanvasSize = 1080;
            }
            SpenSettingPenLayout2.this.mSettingInfo.size = (((SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() / 10.0f) + min2) * SpenSettingPenLayout2.this.mCanvasSize) / 360.0f;
            SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout2.this.mSettingInfo.size);
            SpenSettingPenLayout2.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout2.this.new RptUpdater(), 20L);
        }
    }

    public void setPopup(boolean open) {
        int bodyLayoutHeight;
        if (open) {
            this.mPopupMaxButton.setVisibility(8);
            this.mPopupMinButton.setVisibility(0);
            if (this.mPenAlphaSeekbar.getVisibility() != 0) {
                bodyLayoutHeight = 428;
            } else if (this.isMagicPenEnable) {
                bodyLayoutHeight = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_RIGHT_ALIGN_EVENT;
            } else {
                bodyLayoutHeight = 366;
            }
            playScrollAnimationForBottomBar(2, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(bodyLayoutHeight + 41 + 200));
            return;
        }
        this.mPopupMaxButton.setVisibility(0);
        this.mPopupMinButton.setVisibility(8);
        playScrollAnimationForBottomBar(2, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(41.0f));
    }

    public SpenSettingPenLayout2(Context context, String customImagePath, RelativeLayout relativeLayout) {
        super(context);
        this.mOrientation = 1;
        this.mCanvasView = null;
        this.mPopupListener = null;
        this.mPenAlpha = 255;
        this.mCanvasSize = 1080;
        this.mExpend = false;
        this.mExpandFlag = false;
        this.mPenTypeView = new ArrayList<>();
        this.mPenNameIndex = 0;
        this.mPresetListener = null;
        this.mActionListener = null;
        this.mViewMode = 0;
        this.mBodyLayoutHeight = -2;
        this.mWindowHeight = 0;
        this.mScrollY = 0;
        this.mPreviousSelectedPresetIndex = -1;
        this.mFirstLongPress = true;
        this.mHandler = new Handler();
        this.mCount = 0;
        this.colorPaletteView = null;
        this.MAX_HEIGHT_FLAG = 99999;
        this.currenMagicPenHeight = 99999;
        this.currentOrtherPenHeight = 99999;
        this.previousPenMagicSelected = false;
        this.isMagicPenEnable = false;
        this.isPresetClicked = false;
        this.penTypeLayout = null;
        this.mHandlerForScrollPen = new Handler();
        this.repeatUpdateHandler = new Handler();
        this.mPenSizeAutoIncrement = false;
        this.mPenSizeAutoDecrement = false;
        this.mPenAlphaAutoIncrement = false;
        this.mPenAlphaAutoDecrement = false;
        this.mAdvancedSettingListener = new SpenPenInterface.ChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.1
            @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface.ChangeListener
            public void onChanged(String advancedSetting) {
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    SpenSettingPenInfo info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo();
                    if (info != null) {
                        info.advancedSetting = advancedSetting;
                        SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                    }
                    SpenSettingPenLayout2.this.mPenPreview.invalidate();
                }
            }
        };
        this.mCurrentBeautifyStyle = 0;
        this.mSupportBeautifyPen = false;
        this.BODY_LAYOUT_WIDTH_BEAUTIFY_PEN = 504;
        this.TOTAL_LAYOUT_WIDTH = 329;
        this.BODY_LAYOUT_HEIGHT = 366;
        this.BODY_LAYOUT_HEIGHT_WITH_ALPHA = 428;
        this.BODY_LAYOUT_HEIGHT_MAGIC_PEN = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_RIGHT_ALIGN_EVENT;
        this.TITLE_LAYOUT_HEIGHT = 41;
        this.TYPE_SELECTOR_LAYOUT_HEIGHT = 42;
        this.EXIT_BUTTON_RAW_WIDTH = 42;
        this.EXIT_BUTTON_RAW_HEIGHT = 42;
        this.LINE_BUTTON_RAW_WIDTH = 1;
        this.LINE_BUTTON_RAW_HEIGHT = 17;
        this.BEAUTIFY_RESET_BUTTON_HEIGHT = 40;
        this.mOnClickPresetItemListener = new SpenPenPresetListAdapter.OnClickPresetItemListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.2
            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void deletePresetItem(int presetItemIndex) {
                if (SpenSettingPenLayout2.mPresetInfoList.size() > 0) {
                    if (SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex) != null) {
                        SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).close();
                        SpenSettingPenLayout2.mPresetInfoList.remove(presetItemIndex);
                    }
                    if (SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex == presetItemIndex) {
                        SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = -1;
                    } else if (SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex > presetItemIndex) {
                        SpenSettingPenLayout2 spenSettingPenLayout2 = SpenSettingPenLayout2.this;
                        spenSettingPenLayout2.mPreviousSelectedPresetIndex--;
                        SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex;
                    } else {
                        SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex;
                    }
                    SpenSettingPenLayout2.this.mPresetListAdapter.notifyDataSetChanged();
                    SpenSettingPenLayout2.this.presetDisplay();
                    if (SpenSettingPenLayout2.this.mPresetListener != null) {
                        SpenSettingPenLayout2.this.mPresetListener.onDeleted(presetItemIndex);
                    }
                }
            }

            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void selectPresetItem(int presetItemIndex) throws NumberFormatException {
                SpenSettingPenInfo info;
                for (int i = 0; i < SpenSettingPenLayout2.this.mPenTypeView.size(); i++) {
                    if (SpenSettingPenLayout2.this.mPenTypeView.get(i) != null) {
                        SpenSettingPenLayout2.this.mPenTypeView.get(i).setSelected(false);
                        if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(i).getPenName().equals(SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenName())) {
                            int penNameIdx = i;
                            if (SpenSettingPenLayout2.this.isBeautifyPen(SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenName())) {
                                penNameIdx = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                            }
                            SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = presetItemIndex;
                            SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex = presetItemIndex;
                            SpenSettingPenLayout2.this.mPresetListAdapter.notifyDataSetChanged();
                            SpenSettingPenLayout2.this.presetDisplay();
                            if (SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenName().equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                                SpenSettingPenLayout2.this.isMagicPenEnable = true;
                                SpenSettingPenLayout2.this.mPenAlphaPreview.setVisibility(0);
                            } else {
                                SpenSettingPenLayout2.this.mPenAlphaPreview.setVisibility(8);
                                SpenSettingPenLayout2.this.isMagicPenEnable = false;
                                SpenSettingPenLayout2.this.mColorSelectPickerLayout.setVisibility(0);
                            }
                            SpenSettingPenLayout2.this.mPenTypeView.get(penNameIdx).setSelected(true);
                        }
                    }
                }
                if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                    SpenSettingPenInfo spenSettingPenInfo = SpenSettingPenLayout2.this.mSettingInfo;
                    String penName = SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenName();
                    info.name = penName;
                    spenSettingPenInfo.name = penName;
                    SpenSettingPenInfo spenSettingPenInfo2 = SpenSettingPenLayout2.this.mSettingInfo;
                    float penSize = SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenSize();
                    info.size = penSize;
                    spenSettingPenInfo2.size = penSize;
                    SpenSettingPenInfo spenSettingPenInfo3 = SpenSettingPenLayout2.this.mSettingInfo;
                    int color = SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getColor();
                    info.color = color;
                    spenSettingPenInfo3.color = color;
                    SpenSettingPenInfo spenSettingPenInfo4 = SpenSettingPenLayout2.this.mSettingInfo;
                    String advancedSetting = SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getAdvancedSetting();
                    info.advancedSetting = advancedSetting;
                    spenSettingPenInfo4.advancedSetting = advancedSetting;
                    SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                    SpenSettingPenLayout2.this.setInfo(SpenSettingPenLayout2.this.mSettingInfo);
                    SpenSettingPenLayout2.this.mPenPreview.setPenType(SpenSettingPenLayout2.this.mSettingInfo.name);
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(SpenSettingPenLayout2.this.mSettingInfo.color);
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                    SpenSettingPenLayout2.this.mPenPreview.invalidate();
                }
                if (SpenSettingPenLayout2.this.mPresetListener != null) {
                    SpenSettingPenLayout2.this.mPresetListener.onSelected(presetItemIndex);
                }
                SpenSettingPenLayout2.this.playScrollAnimationChoosePen();
            }

            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void setScrollPresetGridToIndex(int paramInt) {
                SpenSettingPenLayout2.this.mPresetGridView.smoothScrollToPosition(paramInt);
            }
        };
        this.mFirstTimeColorPickerShow = false;
        this.mOnColorChangedListener = new SpenColorPaletteView2.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.3
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorPaletteView2.OnColorChangedListener
            public void colorChanged(int color, int selectedItem) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout2.this.isMinimumMode && selectedItem == 12) {
                    SpenSettingPenLayout2.this.mColorGradationView.setVisibility(0);
                    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(163.0f));
                    SpenSettingPenLayout2.this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams);
                    SpenSettingPenLayout2.this.isMinimumMode = false;
                    SpenSettingPenLayout2.this.deltaOfMiniMode = 0;
                    SpenSettingPenLayout2.this.setExpandBarPosition(SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(428.0f));
                }
                int penPluginIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout2.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout2.this.mPenNameIndex == penPluginIndex && SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null) {
                    if (selectedItem != 13) {
                        SpenSettingPenLayout2.this.mPenSizeSeekbarColor.setColor(color);
                        SpenSettingPenLayout2.this.mPenSizeSeekbarColor.setAlpha(255);
                        SpenSettingPenLayout2.this.mBeautifySeekbarColor.setColor(color);
                        SpenSettingPenLayout2.this.mBeautifyAdvanceCursiveSeekbar.invalidate();
                        SpenSettingPenLayout2.this.mBeautifyAdvanceDummySeekbar.invalidate();
                        SpenSettingPenLayout2.this.mBeautifyAdvanceSustenanceSeekbar.invalidate();
                        SpenSettingPenLayout2.this.mBeautifyAdvanceModulationSeekbar.invalidate();
                        if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                            if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getPenAttribute(1)) {
                                info.color = ((SpenSettingPenLayout2.this.mPenAlpha << 24) & (-16777216)) | (16777215 & color);
                            } else {
                                info.color = color;
                            }
                            SpenSettingPenLayout2.this.mSettingInfo.color = info.color;
                            SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                            SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(info.color);
                            SpenSettingPenLayout2.this.mPenPreview.invalidate();
                            SpenSettingPenLayout2.this.mPenAlphaSeekbarColor.setColor(info.color);
                            SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setColor(info.color);
                            SpenSettingPenLayout2.this.mColorPickerSetting.setColorPickerColor(info.color);
                        }
                    }
                    if (selectedItem == 13) {
                        if (SpenSettingPenLayout2.this.mCanvasView != null) {
                            SpenSettingPenLayout2.this.mPreCanvasPenAction = SpenSettingPenLayout2.this.mCanvasView.getToolTypeAction(2);
                            SpenSettingPenLayout2.this.mPreCanvasFingerAction = SpenSettingPenLayout2.this.mCanvasView.getToolTypeAction(1);
                            SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(2, 5);
                            SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(1, 5);
                        }
                        SpenSettingPenLayout2.this.mColorPaletteView.setColorPickerMode();
                        SpenSettingPenLayout2.mColorPickerShow = true;
                        if (!SpenSettingTextLayout2.mColorPickerShow) {
                            SpenSettingPenLayout2.this.mColorPickerSetting.show();
                            if (!SpenSettingPenLayout2.this.mFirstTimeColorPickerShow) {
                                SpenSettingPenLayout2.this.mColorPickerSetting.movePosition(SpenSettingPenLayout2.this.mCanvasLayout.getWidth() / 2, SpenSettingPenLayout2.this.mCanvasLayout.getHeight() / 2);
                                SpenSettingPenLayout2.this.mFirstTimeColorPickerShow = true;
                            }
                        }
                    }
                }
            }
        };
        this.mColorPickerColorChangeListener = new SpenColorGradationView2.onColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.4
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorGradationView2.onColorChangedListener
            public void onColorChanged(int color, int x, int y) {
                SpenSettingPenInfo info;
                int penPluginIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout2.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null) {
                    SpenSettingPenLayout2.this.mPenSizeSeekbarColor.setColor(color);
                    SpenSettingPenLayout2.this.mPenSizeSeekbarColor.setAlpha(255);
                    SpenSettingPenLayout2.this.mBeautifySeekbarColor.setColor(color);
                    SpenSettingPenLayout2.this.mBeautifyAdvanceCursiveSeekbar.invalidate();
                    SpenSettingPenLayout2.this.mBeautifyAdvanceDummySeekbar.invalidate();
                    SpenSettingPenLayout2.this.mBeautifyAdvanceSustenanceSeekbar.invalidate();
                    SpenSettingPenLayout2.this.mBeautifyAdvanceModulationSeekbar.invalidate();
                    if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                        if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                            info.color = ((SpenSettingPenLayout2.this.mPenAlpha << 24) & (-16777216)) | (16777215 & color);
                        } else {
                            info.color = color;
                        }
                        SpenSettingPenLayout2.this.mSettingInfo.color = info.color;
                        SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                        SpenSettingPenLayout2.this.mPenAlphaSeekbarColor.setColor(info.color);
                        SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(info.color);
                        SpenSettingPenLayout2.this.mPenPreview.invalidate();
                        SpenSettingPenLayout2.this.mColorPaletteView.setColor(info.color);
                        SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(info.color);
                        SpenSettingPenLayout2.this.mColorPickerSetting.setColorPickerColor(info.color);
                    }
                }
            }
        };
        this.handler = new Handler();
        this.mPenAlphaChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.5
            int oldProgress = -1;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout2.this.isMagicPenEnable) {
                    SpenSettingPenLayout2.this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingPenLayout2.this.alphaDrawable.setAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                        }
                    });
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout2.this.isMagicPenEnable) {
                    SpenSettingPenLayout2.this.alphaDrawable.setAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingPenInfo info;
                int penPluginIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout2.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null && seekBar == SpenSettingPenLayout2.this.mPenAlphaSeekbar && this.oldProgress != progress) {
                    if (SpenSettingPenLayout2.this.mPenAlphaPreview.getVisibility() == 0) {
                        SpenSettingPenLayout2.this.mPenAlphaPreview.setAlpha((float) (progress / 100.0d));
                    }
                    SpenSettingPenLayout2.this.mPenAlphaTextView.setText(String.valueOf(String.valueOf(progress + 1)) + "%");
                    int seek_label_pos = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(43.0f) + ((int) (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(193.0f) * (progress / 99.0f)));
                    SpenSettingPenLayout2.this.mPenAlphaSeekbar.setContentDescription(String.valueOf(SpenSettingPenLayout2.this.mPenAlphaTextView.getText().toString()) + "\u0000");
                    SpenSettingPenLayout2.this.mPenAlphaTextView.setX(seek_label_pos);
                    SpenSettingPenLayout2.this.mPenAlphaTextView.setY(SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                    this.oldProgress = progress;
                    if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                        if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                            SpenSettingPenLayout2.this.mPenAlpha = Math.round((progress * 255.0f) / 99.0f);
                            SpenSettingPenLayout2.this.mPenPreview.setStrokeAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                            SpenSettingPenLayout2.this.mPenPreview.invalidate();
                            info.color = ((SpenSettingPenLayout2.this.mPenAlpha << 24) & (-16777216)) | (info.color & 16777215);
                            SpenSettingPenLayout2.this.mPenAlphaSeekbarColor.setColor(info.color);
                            SpenSettingPenLayout2.this.mSettingInfo.color = info.color;
                        }
                        SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                        SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(info.color);
                    }
                    if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.getProgress() == SpenSettingPenLayout2.this.mPenAlphaSeekbar.getMax()) {
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setAlpha(0.2f);
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setSelected(false);
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setEnabled(false);
                        if (SpenSettingPenLayout2.this.mPenAlphaAutoIncrement) {
                            SpenSettingPenLayout2.this.mPenAlphaAutoIncrement = false;
                        }
                    } else {
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setAlpha(1.0f);
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.getProgress() == 0) {
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setAlpha(0.2f);
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setSelected(false);
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setEnabled(false);
                        if (SpenSettingPenLayout2.this.mPenAlphaAutoDecrement) {
                            SpenSettingPenLayout2.this.mPenAlphaAutoDecrement = false;
                        }
                    } else {
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setAlpha(1.0f);
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout2.this.isMagicPenEnable) {
                        if (SpenSettingPenLayout2.this.alphaDrawable != null) {
                            SpenSettingPenLayout2.this.alphaDrawable.setAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                        }
                        SpenSettingPenLayout2.this.mPenAlphaSeekbarColor.setColor(0);
                    }
                }
            }
        };
        this.mPenSizeChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject() != null) {
                    float min = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                    float max = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMaxSettingValue();
                    if (SpenSettingPenLayout2.this.mPenAlphaPreview.getVisibility() == 0) {
                        float mAlphaWidth = (float) (2.7d + ((progress * 6.3d) / 140.0d));
                        RelativeLayout.LayoutParams penPreviewLayoutParams02 = new RelativeLayout.LayoutParams(-1, SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(mAlphaWidth));
                        penPreviewLayoutParams02.addRule(9);
                        penPreviewLayoutParams02.addRule(12);
                        penPreviewLayoutParams02.rightMargin = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(3.0f);
                        penPreviewLayoutParams02.leftMargin = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(2.0f);
                        penPreviewLayoutParams02.bottomMargin = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(9.5f - (mAlphaWidth / 2.0f));
                        SpenSettingPenLayout2.this.mPenAlphaPreview.setLayoutParams(penPreviewLayoutParams02);
                    }
                    SpenSettingPenLayout2.this.mPenSizeTextView.setText(String.valueOf((((int) min) * 10) + progress));
                    int seek_label_pos = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(45.0f) + ((int) (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(197.0f) * (progress / ((max - min) * 10.0f))));
                    if ((((int) min) * 10) + progress >= 100) {
                        seek_label_pos = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(42.0f) + ((int) (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(197.0f) * (progress / ((max - min) * 10.0f))));
                    }
                    SpenSettingPenLayout2.this.mPenSizeSeekbar.setContentDescription(String.valueOf(SpenSettingPenLayout2.this.mPenSizeTextView.getText().toString()) + "\u0000");
                    SpenSettingPenLayout2.this.mPenSizeTextView.setX(seek_label_pos);
                    SpenSettingPenLayout2.this.mPenSizeTextView.setY(SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                    if (SpenSettingPenLayout2.this.mCanvasView != null) {
                        if (SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight()) {
                            SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight();
                        }
                        if (SpenSettingPenLayout2.this.mCanvasSize == 0) {
                            SpenSettingPenLayout2.this.mCanvasSize = 1080;
                        }
                    } else {
                        SpenSettingPenLayout2.this.mCanvasSize = 1080;
                    }
                    SpenSettingPenLayout2.this.mSettingInfo.size = (((progress / 10.0f) + min) * SpenSettingPenLayout2.this.mCanvasSize) / 360.0f;
                    SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                    SpenSettingPenLayout2.this.mPenPreview.invalidate();
                    if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                        info.size = SpenSettingPenLayout2.this.mSettingInfo.size;
                        SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                    }
                    if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() == SpenSettingPenLayout2.this.mPenSizeSeekbar.getMax()) {
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setAlpha(0.2f);
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setSelected(false);
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setEnabled(false);
                        if (SpenSettingPenLayout2.this.mPenSizeAutoIncrement) {
                            SpenSettingPenLayout2.this.mPenSizeAutoIncrement = false;
                        }
                    } else {
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setAlpha(1.0f);
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() == 0) {
                        SpenSettingPenLayout2.this.mPenSizeMinusButton.setAlpha(0.2f);
                        SpenSettingPenLayout2.this.mPenSizeMinusButton.setSelected(false);
                        SpenSettingPenLayout2.this.mPenSizeMinusButton.setEnabled(false);
                        if (SpenSettingPenLayout2.this.mPenSizeAutoDecrement) {
                            SpenSettingPenLayout2.this.mPenSizeAutoDecrement = false;
                            return;
                        }
                        return;
                    }
                    SpenSettingPenLayout2.this.mPenSizeMinusButton.setAlpha(1.0f);
                    SpenSettingPenLayout2.this.mPenSizeMinusButton.setEnabled(true);
                }
            }
        };
        this.mPenSizePlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout2.this.mPenSizeAutoIncrement = true;
                SpenSettingPenLayout2.this.mPenSizePlusButton.setSelected(true);
                SpenSettingPenLayout2.this.repeatUpdateHandler.post(SpenSettingPenLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mPenTypeTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 1) {
                    if (!SpenSettingPenLayout2.this.isPresetClicked) {
                        float x = event.getX();
                        float y = event.getY();
                        int index = (int) (((x - ((SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(65.0f) / SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(89.0f)) * (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(89.0f) - y))) + SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(21.0f)) / SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(56.0f));
                        if (index < 0) {
                            index = 0;
                        } else if (index > SpenSettingPenLayout2.this.mPenTypeView.size() - 1) {
                            index = SpenSettingPenLayout2.this.mPenTypeView.size() - 1;
                        }
                        if (index < SpenSettingPenLayout2.this.mNumberOfPenExist) {
                            View v1 = SpenSettingPenLayout2.this.localPenTypeViewGroup.getChildAt(index);
                            for (int i = 0; i < SpenSettingPenLayout2.this.mPenTypeView.size(); i++) {
                                if (v1 == SpenSettingPenLayout2.this.mPenTypeView.get(i)) {
                                    SpenSettingPenLayout2.this.penSelectIndex(i);
                                }
                            }
                            SpenSettingPenLayout2.this.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                } else {
                    SpenSettingPenLayout2.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mPenTypeHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.9
            private int preIndex = 0;

            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                int index = (int) (((x - ((SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(65.0f) / SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(89.0f)) * (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(89.0f) - y))) + SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(21.0f)) / SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(56.0f));
                if (index < 0) {
                    index = 0;
                } else if (index > SpenSettingPenLayout2.this.mPenTypeView.size() - 1) {
                    index = SpenSettingPenLayout2.this.mPenTypeView.size() - 1;
                }
                if (this.preIndex < 0) {
                    this.preIndex = 0;
                } else if (this.preIndex > SpenSettingPenLayout2.this.mPenTypeView.size() - 1) {
                    this.preIndex = SpenSettingPenLayout2.this.mPenTypeView.size() - 1;
                }
                if (index != this.preIndex) {
                    event.setAction(10);
                    SpenSettingPenLayout2.this.mPenTypeView.get(this.preIndex).dispatchGenericMotionEvent(event);
                    event.setAction(9);
                    SpenSettingPenLayout2.this.mPenTypeView.get(index).sendAccessibilityEvent(128);
                }
                SpenSettingPenLayout2.this.mPenTypeView.get(index).dispatchGenericMotionEvent(event);
                this.preIndex = index;
                return true;
            }
        };
        this.mPenSizePlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout2.this.mPenSizeAutoIncrement) {
                    SpenSettingPenLayout2.this.mPenSizePlusButton.setSelected(false);
                    SpenSettingPenLayout2.this.mPenSizeAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPenSizeMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout2.this.mPenSizeAutoDecrement = true;
                SpenSettingPenLayout2.this.mPenSizeMinusButton.setSelected(true);
                SpenSettingPenLayout2.this.repeatUpdateHandler.post(SpenSettingPenLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mPenSizeMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout2.this.mPenSizeAutoDecrement) {
                    SpenSettingPenLayout2.this.mPenSizeMinusButton.setSelected(false);
                    SpenSettingPenLayout2.this.mPenSizeAutoDecrement = false;
                }
                return false;
            }
        };
        this.mPenAlphaPlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout2.this.mPenAlphaAutoIncrement = true;
                SpenSettingPenLayout2.this.mOpacityPlusButton.setSelected(true);
                SpenSettingPenLayout2.this.repeatUpdateHandler.post(SpenSettingPenLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mPenAlphaPlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout2.this.mPenAlphaAutoIncrement) {
                    SpenSettingPenLayout2.this.mOpacityPlusButton.setSelected(false);
                    SpenSettingPenLayout2.this.mPenAlphaAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPenAlphaMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout2.this.mPenAlphaAutoDecrement = true;
                SpenSettingPenLayout2.this.mOpacityMinusButton.setSelected(true);
                SpenSettingPenLayout2.this.repeatUpdateHandler.post(SpenSettingPenLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mPenAlphaMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout2.this.mPenAlphaAutoDecrement) {
                    SpenSettingPenLayout2.this.mOpacityMinusButton.setSelected(false);
                    SpenSettingPenLayout2.this.mPenAlphaAutoDecrement = false;
                }
                return false;
            }
        };
        this.mPenSizePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(1);
                float min = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    if (SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight()) {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth();
                    } else {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight();
                    }
                    if (SpenSettingPenLayout2.this.mCanvasSize == 0) {
                        SpenSettingPenLayout2.this.mCanvasSize = 1080;
                    }
                } else {
                    SpenSettingPenLayout2.this.mCanvasSize = 1080;
                }
                SpenSettingPenLayout2.this.mSettingInfo.size = (((SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout2.this.mCanvasSize) / 360.0f;
                SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout2.this.mSettingInfo.size);
            }
        };
        this.mPenSizeMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() > 0) {
                    SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(-1);
                }
                float min = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    if (SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight()) {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth();
                    } else {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight();
                    }
                    if (SpenSettingPenLayout2.this.mCanvasSize == 0) {
                        SpenSettingPenLayout2.this.mCanvasSize = 1080;
                    }
                } else {
                    SpenSettingPenLayout2.this.mCanvasSize = 1080;
                }
                SpenSettingPenLayout2.this.mSettingInfo.size = (((SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout2.this.mCanvasSize) / 360.0f;
                if (SpenSettingPenLayout2.this.mSettingInfo.size >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                } else {
                    SpenSettingPenLayout2.this.mSettingInfo.size = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                }
            }
        };
        this.mPenAlphaPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(1);
            }
        };
        this.mPenAlphaMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(-1);
            }
        };
        this.mPaletteNextButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int index = SpenSettingPenLayout2.this.colorPaletteView.getCurrentTableIndex();
                if (index == 3) {
                    SpenSettingPenLayout2.this.mPaletteLeftButton.setAlpha(1.0f);
                    SpenSettingPenLayout2.this.mPaletteLeftButton.setEnabled(true);
                }
                SpenSettingPenLayout2.this.colorPaletteView.setNextColorTable(index);
                SpenSettingPenLayout2.this.mColorPaletteView.setSelectBoxPos(SpenSettingPenLayout2.this.mSettingInfo.color);
                if (SpenSettingPenLayout2.this.colorPaletteView.getCurrentTableIndex() == 2) {
                    SpenSettingPenLayout2.this.mPaletteRightButton.setAlpha(0.2f);
                    SpenSettingPenLayout2.this.mPaletteRightButton.setEnabled(false);
                }
            }
        };
        this.mPaletteBackButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int index = SpenSettingPenLayout2.this.colorPaletteView.getCurrentTableIndex();
                if (index == 2) {
                    SpenSettingPenLayout2.this.mPaletteRightButton.setAlpha(1.0f);
                    SpenSettingPenLayout2.this.mPaletteRightButton.setEnabled(true);
                }
                SpenSettingPenLayout2.this.colorPaletteView.setBackColorTable(index);
                SpenSettingPenLayout2.this.mColorPaletteView.setSelectBoxPos(SpenSettingPenLayout2.this.mSettingInfo.color);
                if (SpenSettingPenLayout2.this.colorPaletteView.getCurrentTableIndex() == 3) {
                    SpenSettingPenLayout2.this.mPaletteLeftButton.setAlpha(0.2f);
                    SpenSettingPenLayout2.this.mPaletteLeftButton.setEnabled(false);
                }
            }
        };
        this.mPenTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws NumberFormatException {
                SpenSettingPenLayout2.this.penSelection(v);
            }
        };
        this.mColorPickerCurrentColorListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                    SpenSettingPenLayout2.this.mSettingInfo.color = info.color;
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(info.color);
                    SpenSettingPenLayout2.this.mPenPreview.invalidate();
                    SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                }
                SpenSettingPenLayout2.this.mColorPaletteView.setColor(SpenSettingPenLayout2.this.mSettingInfo.color);
                SpenSettingPenLayout2.this.mColorPaletteView.invalidate();
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(2, SpenSettingPenLayout2.this.mPreCanvasPenAction);
                    SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(1, SpenSettingPenLayout2.this.mPreCanvasFingerAction);
                }
                SpenSettingPenLayout2.mColorPickerShow = false;
                SpenSettingPenLayout2.this.mColorPickerSetting.hide();
                SpenSettingPenLayout2.this.setVisibility(0);
            }
        };
        this.mPopupButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SpenSettingPenLayout2.this.mPopupMaxButton) {
                    if (SpenSettingPenLayout2.this.mPopupListener != null) {
                        SpenSettingPenLayout2.this.mPopupListener.onPopup(true);
                    }
                } else if (v == SpenSettingPenLayout2.this.mPopupMinButton && SpenSettingPenLayout2.this.mPopupListener != null) {
                    SpenSettingPenLayout2.this.mPopupListener.onPopup(false);
                }
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    if (SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor() != 0) {
                        if (SpenSettingPenLayout2.this.mCanvasView != null) {
                            SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(2, SpenSettingPenLayout2.this.mPreCanvasPenAction);
                            SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(1, SpenSettingPenLayout2.this.mPreCanvasFingerAction);
                        }
                        SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor());
                        SpenSettingPenLayout2.this.mPenPreview.invalidate();
                        SpenSettingPenLayout2.this.mSettingInfo.color = SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor();
                        if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                            info.color = SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor();
                            SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                        }
                        SpenSettingPenLayout2.this.mColorPaletteView.setColorPickerColor(SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor());
                        SpenSettingPenLayout2.this.mColorPaletteView.invalidate();
                    }
                    SpenSettingPenLayout2.this.mColorPickerSetting.hide();
                }
                if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject() != null && SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getPenAttribute(4)) {
                    SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().hideAdvancedSetting();
                    SpenSettingPenLayout2.this.mAdvancedSettingShow = false;
                }
                SpenSettingPenLayout2.mColorPickerShow = false;
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingPenLayout2.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mOnConsumedHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.28
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                return true;
            }
        };
        this.mAdvancedSettingButtonListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject() != null) {
                    if (!SpenSettingPenLayout2.this.mAdvancedSettingShow) {
                        SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().showAdvancedSetting(SpenSettingPenLayout2.this.mContext, SpenSettingPenLayout2.this.mAdvancedSettingListener, (ViewGroup) SpenSettingPenLayout2.this.getParent());
                    } else {
                        SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().hideAdvancedSetting();
                    }
                    SpenSettingPenLayout2.this.mAdvancedSettingShow = !SpenSettingPenLayout2.this.mAdvancedSettingShow;
                }
            }
        };
        this.mPreSetAddButtonListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Resources.NotFoundException {
                if (SpenSettingPenLayout2.mPresetInfoList == null) {
                    SpenSettingPenLayout2.mPresetInfoList = new ArrayList();
                }
                if (SpenSettingPenLayout2.mPresetInfoList.size() >= 36) {
                    String strPreset = SpenSettingPenLayout2.this.mStringUtil.setString("string_reached_maximum_preset");
                    if (strPreset != null) {
                        CharSequence text = String.format(strPreset, 36);
                        Toast toast = Toast.makeText(SpenSettingPenLayout2.this.mContext, text, 0);
                        toast.show();
                        return;
                    }
                    return;
                }
                for (SpenPenPresetInfo info : SpenSettingPenLayout2.mPresetInfoList) {
                    if (info.getPenName().equals(SpenSettingPenLayout2.this.mSettingInfo.name) && info.getPenSize() == SpenSettingPenLayout2.this.mSettingInfo.size && info.getColor() == SpenSettingPenLayout2.this.mSettingInfo.color && info.getAdvancedSetting().equals(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting)) {
                        CharSequence text2 = SpenSettingPenLayout2.this.mStringUtil.setString("string_already_exists");
                        Toast toast2 = Toast.makeText(SpenSettingPenLayout2.this.mContext, text2, 0);
                        toast2.show();
                        return;
                    }
                }
                SpenPenPresetInfo presetInfoItem = new SpenPenPresetInfo();
                presetInfoItem.setPenName(SpenSettingPenLayout2.this.mSettingInfo.name);
                presetInfoItem.setBitmapSize(SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(65.0f), SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(65.0f));
                presetInfoItem.setPenSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                presetInfoItem.setColor(SpenSettingPenLayout2.this.mSettingInfo.color);
                presetInfoItem.setAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                presetInfoItem.setPresetImageName(SpenSettingPenLayout2.this.mPresetListAdapter.getPresetImage(SpenSettingPenLayout2.this.mSettingInfo.name));
                SpenSettingPenLayout2.mPresetInfoList.add(presetInfoItem);
                SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout2.mPresetInfoList.size() - 1;
                SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex = SpenSettingPenLayout2.mPresetInfoList.size() - 1;
                SpenSettingPenLayout2.this.mPresetListAdapter.notifyDataSetChanged();
                SpenSettingPenLayout2.this.presetDisplay();
                if (SpenSettingPenLayout2.this.mPresetListener != null) {
                    SpenSettingPenLayout2.this.mPresetListener.onAdded(SpenSettingPenLayout2.this.mSettingInfo);
                }
                SpenSettingPenLayout2.this.mPresetGridView.smoothScrollToPosition(SpenSettingPenLayout2.mPresetInfoList.size() - 1);
            }
        };
        this.mExpendBarListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.31
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingPenLayout2.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mBeautifyEnablecheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.32
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) throws NumberFormatException {
                SpenSettingPenLayout2.this.showBeautifySettingViews(isChecked);
                if (SpenSettingPenLayout2.this.isChinesePen(SpenSettingPenLayout2.this.mSettingInfo.name) || SpenSettingPenLayout2.this.isBeautifyPen(SpenSettingPenLayout2.this.mSettingInfo.name)) {
                    if (isChecked) {
                        SpenSettingPenLayout2.this.mPenNameIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout2.BEAUTIFY_PEN_NAME);
                    } else {
                        SpenSettingPenLayout2.this.mPenNameIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                    }
                    SpenSettingPenLayout2.this.mSettingInfo.name = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenName();
                    SpenSettingPenLayout2.this.updateBeautifySettingData();
                    SpenSettingPenLayout2.this.beautifyUpdateSettingUI(isChecked);
                    SpenSettingPenLayout2.this.drawExpendImage(SpenSettingPenLayout2.this.mSettingInfo.name);
                }
            }
        };
        this.mBeautifyStyleBtnsListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout2.this.mBeautifyStyleBtnViews != null) {
                    int beautifyStyleIndex = 0;
                    Iterator<ImageButton> it = SpenSettingPenLayout2.this.mBeautifyStyleBtnViews.iterator();
                    while (it.hasNext()) {
                        ImageButton styleBtn = it.next();
                        if (styleBtn.equals(v)) {
                            if (beautifyStyleIndex == SpenSettingPenLayout2.this.mCurrentBeautifyStyle) {
                                break;
                            }
                            SpenSettingPenLayout2.this.mCurrentBeautifyStyle = beautifyStyleIndex;
                            styleBtn.setSelected(true);
                        } else {
                            styleBtn.setSelected(false);
                        }
                        beautifyStyleIndex++;
                    }
                    SpenSettingPenLayout2.this.resetBeautifyAdvanceDataAndUpdateSeekBarUi(SpenSettingPenLayout2.this.mCurrentBeautifyStyle);
                }
            }
        };
        this.mBeautifyAdvanceCursiveChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.34
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String cursiveStr = String.valueOf(SpenSettingPenLayout2.this.mStringUtil.setString("string_cursive")) + " " + progress;
                SpenSettingPenLayout2.this.mBeautifyCursiveTextView.setText(cursiveStr);
                SpenSettingPenLayout2.this.setBeautifyAdvancedDataToPlugin(2, progress);
                SpenSettingPenLayout2.this.updateBeautifySettingData();
                SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout2.this.mPenPreview.invalidate();
            }
        };
        this.mBeautifyAdvanceSustenanceChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.35
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String sustenanceStr = String.valueOf(SpenSettingPenLayout2.this.mSustenanceStr) + " " + progress;
                SpenSettingPenLayout2.this.mBeautifySustenanceTextView.setText(sustenanceStr);
                SpenSettingPenLayout2.this.setBeautifyAdvancedDataToPlugin(3, progress);
                SpenSettingPenLayout2.this.updateBeautifySettingData();
                SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout2.this.mPenPreview.invalidate();
            }
        };
        this.mBeautifyAdvanceDummyChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.36
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String dummyStr = String.valueOf(SpenSettingPenLayout2.this.mStringUtil.setString("string_dummy")) + " " + progress;
                SpenSettingPenLayout2.this.mBeautifyDummyTextView.setText(dummyStr);
                SpenSettingPenLayout2.this.setBeautifyAdvancedDataToPlugin(4, progress);
                SpenSettingPenLayout2.this.updateBeautifySettingData();
                SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout2.this.mPenPreview.invalidate();
            }
        };
        this.mBeautifyAdvanceModulationChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.37
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String modulationStr = String.valueOf(SpenSettingPenLayout2.this.mStringUtil.setString("string_modulation")) + " " + progress;
                SpenSettingPenLayout2.this.mBeautifyModulationTextView.setText(modulationStr);
                SpenSettingPenLayout2.this.setBeautifyAdvancedDataToPlugin(6, progress);
                SpenSettingPenLayout2.this.updateBeautifySettingData();
                SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout2.this.mPenPreview.invalidate();
            }
        };
        this.mBeautifyAdvanceCursivePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceCursiveMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceSustenancePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceSustenanceMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceDummyPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.42
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceDummyMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.43
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceModulationPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.44
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceModulationMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.45
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceResetButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.resetBeautifyAdvanceDataAndUpdateSeekBarUi(SpenSettingPenLayout2.this.mCurrentBeautifyStyle);
            }
        };
        this.mPenSizeKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.47
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout2.this.mPenSizeSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout2.this.mPenSizeSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() != SpenSettingPenLayout2.this.mPenSizeSeekbar.getMax()) {
                                SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mPenAlphaKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.48
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.getProgress() != SpenSettingPenLayout2.this.mPenAlphaSeekbar.getMax()) {
                                SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.horizontalScrollViewTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.49
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() != 1 || SpenSettingPenLayout2.this.mPenTypeHorizontalScrollView2.getScrollX() <= SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(SpenSettingPenLayout2.SUITABLE_WIDTH_IN_ANIMATION_SCROLL)) {
                    return false;
                }
                SpenSettingPenLayout2.this.playScrollAnimation(10, SpenSettingPenLayout2.this.mPenTypeHorizontalScrollView2.getScrollX(), SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(SpenSettingPenLayout2.SUITABLE_WIDTH_IN_ANIMATION_SCROLL));
                return false;
            }
        };
        this.deltaOfMiniMode = 0;
        this.isMinimumMode = false;
        this.mNumberOfPenExist = 6;
        this.mScrollViewListner = new SpenScrollView.scrollChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.50
            @Override // com.samsung.android.sdk.pen.settingui.SpenScrollView.scrollChangedListener
            public void scrollChanged(int scrollY) {
                RelativeLayout.LayoutParams PaletteBgParam;
                SpenSettingPenLayout2.this.mScrollY = scrollY;
                if (SpenSettingPenLayout2.this.mPenAlphaSeekbarView.getVisibility() == 0) {
                    PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(163.0f) - (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(428.0f) - SpenSettingPenLayout2.this.mBodyLayoutHeight)) + SpenSettingPenLayout2.this.mScrollY);
                } else {
                    PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(163.0f) - (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(366.0f) - SpenSettingPenLayout2.this.mBodyLayoutHeight)) + SpenSettingPenLayout2.this.mScrollY);
                }
                PaletteBgParam.setMargins(0, 0, SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(-1.5f), 0);
                if (PaletteBgParam.height >= 0) {
                    SpenSettingPenLayout2.this.mPaletteBg.setLayoutParams(PaletteBgParam);
                }
            }
        };
        this.mBeautifyStr = Beautify.TAG;
        this.mSustenanceStr = "Sustenance";
        this.mCurrentBeautifyAdvanceSettingValues = new int[][]{new int[]{11, 2, 5, 8, 1, 15, 70, 11, 0, 1}, new int[]{12, 2, 5, 1, 1, 18, 70, 13, 0, 1}, new int[]{5, 2, 2, 2, 1, 18, 70, 5, 0, 1}, new int[]{6, 2, 3, 3, 1, 12, 70, 6, 0, 1}, new int[]{1, 2, 2, 8, 1, 15, 70, 3, 0, 1}, new int[]{3, 1, 3, 5, 1, 12, 70, 1, 0, 1}};
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, mScale);
        this.mStringUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mContext = context;
        this.mCanvasLayout = relativeLayout;
        this.mBodyLayoutHeight = -2;
        this.mPluginManager = SpenPluginManager.getInstance(context);
        if (this.mPluginManager != null) {
            initPenPlugin(context);
        }
        this.mSupportBeautifyPen = false;
        this.mSettingInfo = new SpenSettingPenInfo();
        initButtonValue();
        initView(customImagePath);
        setListener();
        this.mMovableRect = new Rect();
    }

    public SpenSettingPenLayout2(Context context, String customImagePath, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.mOrientation = 1;
        this.mCanvasView = null;
        this.mPopupListener = null;
        this.mPenAlpha = 255;
        this.mCanvasSize = 1080;
        this.mExpend = false;
        this.mExpandFlag = false;
        this.mPenTypeView = new ArrayList<>();
        this.mPenNameIndex = 0;
        this.mPresetListener = null;
        this.mActionListener = null;
        this.mViewMode = 0;
        this.mBodyLayoutHeight = -2;
        this.mWindowHeight = 0;
        this.mScrollY = 0;
        this.mPreviousSelectedPresetIndex = -1;
        this.mFirstLongPress = true;
        this.mHandler = new Handler();
        this.mCount = 0;
        this.colorPaletteView = null;
        this.MAX_HEIGHT_FLAG = 99999;
        this.currenMagicPenHeight = 99999;
        this.currentOrtherPenHeight = 99999;
        this.previousPenMagicSelected = false;
        this.isMagicPenEnable = false;
        this.isPresetClicked = false;
        this.penTypeLayout = null;
        this.mHandlerForScrollPen = new Handler();
        this.repeatUpdateHandler = new Handler();
        this.mPenSizeAutoIncrement = false;
        this.mPenSizeAutoDecrement = false;
        this.mPenAlphaAutoIncrement = false;
        this.mPenAlphaAutoDecrement = false;
        this.mAdvancedSettingListener = new SpenPenInterface.ChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.1
            @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface.ChangeListener
            public void onChanged(String advancedSetting) {
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    SpenSettingPenInfo info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo();
                    if (info != null) {
                        info.advancedSetting = advancedSetting;
                        SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                    }
                    SpenSettingPenLayout2.this.mPenPreview.invalidate();
                }
            }
        };
        this.mCurrentBeautifyStyle = 0;
        this.mSupportBeautifyPen = false;
        this.BODY_LAYOUT_WIDTH_BEAUTIFY_PEN = 504;
        this.TOTAL_LAYOUT_WIDTH = 329;
        this.BODY_LAYOUT_HEIGHT = 366;
        this.BODY_LAYOUT_HEIGHT_WITH_ALPHA = 428;
        this.BODY_LAYOUT_HEIGHT_MAGIC_PEN = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_RIGHT_ALIGN_EVENT;
        this.TITLE_LAYOUT_HEIGHT = 41;
        this.TYPE_SELECTOR_LAYOUT_HEIGHT = 42;
        this.EXIT_BUTTON_RAW_WIDTH = 42;
        this.EXIT_BUTTON_RAW_HEIGHT = 42;
        this.LINE_BUTTON_RAW_WIDTH = 1;
        this.LINE_BUTTON_RAW_HEIGHT = 17;
        this.BEAUTIFY_RESET_BUTTON_HEIGHT = 40;
        this.mOnClickPresetItemListener = new SpenPenPresetListAdapter.OnClickPresetItemListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.2
            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void deletePresetItem(int presetItemIndex) {
                if (SpenSettingPenLayout2.mPresetInfoList.size() > 0) {
                    if (SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex) != null) {
                        SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).close();
                        SpenSettingPenLayout2.mPresetInfoList.remove(presetItemIndex);
                    }
                    if (SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex == presetItemIndex) {
                        SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = -1;
                    } else if (SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex > presetItemIndex) {
                        SpenSettingPenLayout2 spenSettingPenLayout2 = SpenSettingPenLayout2.this;
                        spenSettingPenLayout2.mPreviousSelectedPresetIndex--;
                        SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex;
                    } else {
                        SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex;
                    }
                    SpenSettingPenLayout2.this.mPresetListAdapter.notifyDataSetChanged();
                    SpenSettingPenLayout2.this.presetDisplay();
                    if (SpenSettingPenLayout2.this.mPresetListener != null) {
                        SpenSettingPenLayout2.this.mPresetListener.onDeleted(presetItemIndex);
                    }
                }
            }

            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void selectPresetItem(int presetItemIndex) throws NumberFormatException {
                SpenSettingPenInfo info;
                for (int i = 0; i < SpenSettingPenLayout2.this.mPenTypeView.size(); i++) {
                    if (SpenSettingPenLayout2.this.mPenTypeView.get(i) != null) {
                        SpenSettingPenLayout2.this.mPenTypeView.get(i).setSelected(false);
                        if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(i).getPenName().equals(SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenName())) {
                            int penNameIdx = i;
                            if (SpenSettingPenLayout2.this.isBeautifyPen(SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenName())) {
                                penNameIdx = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                            }
                            SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = presetItemIndex;
                            SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex = presetItemIndex;
                            SpenSettingPenLayout2.this.mPresetListAdapter.notifyDataSetChanged();
                            SpenSettingPenLayout2.this.presetDisplay();
                            if (SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenName().equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                                SpenSettingPenLayout2.this.isMagicPenEnable = true;
                                SpenSettingPenLayout2.this.mPenAlphaPreview.setVisibility(0);
                            } else {
                                SpenSettingPenLayout2.this.mPenAlphaPreview.setVisibility(8);
                                SpenSettingPenLayout2.this.isMagicPenEnable = false;
                                SpenSettingPenLayout2.this.mColorSelectPickerLayout.setVisibility(0);
                            }
                            SpenSettingPenLayout2.this.mPenTypeView.get(penNameIdx).setSelected(true);
                        }
                    }
                }
                if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                    SpenSettingPenInfo spenSettingPenInfo = SpenSettingPenLayout2.this.mSettingInfo;
                    String penName = SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenName();
                    info.name = penName;
                    spenSettingPenInfo.name = penName;
                    SpenSettingPenInfo spenSettingPenInfo2 = SpenSettingPenLayout2.this.mSettingInfo;
                    float penSize = SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getPenSize();
                    info.size = penSize;
                    spenSettingPenInfo2.size = penSize;
                    SpenSettingPenInfo spenSettingPenInfo3 = SpenSettingPenLayout2.this.mSettingInfo;
                    int color = SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getColor();
                    info.color = color;
                    spenSettingPenInfo3.color = color;
                    SpenSettingPenInfo spenSettingPenInfo4 = SpenSettingPenLayout2.this.mSettingInfo;
                    String advancedSetting = SpenSettingPenLayout2.mPresetInfoList.get(presetItemIndex).getAdvancedSetting();
                    info.advancedSetting = advancedSetting;
                    spenSettingPenInfo4.advancedSetting = advancedSetting;
                    SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                    SpenSettingPenLayout2.this.setInfo(SpenSettingPenLayout2.this.mSettingInfo);
                    SpenSettingPenLayout2.this.mPenPreview.setPenType(SpenSettingPenLayout2.this.mSettingInfo.name);
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(SpenSettingPenLayout2.this.mSettingInfo.color);
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                    SpenSettingPenLayout2.this.mPenPreview.invalidate();
                }
                if (SpenSettingPenLayout2.this.mPresetListener != null) {
                    SpenSettingPenLayout2.this.mPresetListener.onSelected(presetItemIndex);
                }
                SpenSettingPenLayout2.this.playScrollAnimationChoosePen();
            }

            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void setScrollPresetGridToIndex(int paramInt) {
                SpenSettingPenLayout2.this.mPresetGridView.smoothScrollToPosition(paramInt);
            }
        };
        this.mFirstTimeColorPickerShow = false;
        this.mOnColorChangedListener = new SpenColorPaletteView2.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.3
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorPaletteView2.OnColorChangedListener
            public void colorChanged(int color, int selectedItem) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout2.this.isMinimumMode && selectedItem == 12) {
                    SpenSettingPenLayout2.this.mColorGradationView.setVisibility(0);
                    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(163.0f));
                    SpenSettingPenLayout2.this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams);
                    SpenSettingPenLayout2.this.isMinimumMode = false;
                    SpenSettingPenLayout2.this.deltaOfMiniMode = 0;
                    SpenSettingPenLayout2.this.setExpandBarPosition(SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(428.0f));
                }
                int penPluginIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout2.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout2.this.mPenNameIndex == penPluginIndex && SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null) {
                    if (selectedItem != 13) {
                        SpenSettingPenLayout2.this.mPenSizeSeekbarColor.setColor(color);
                        SpenSettingPenLayout2.this.mPenSizeSeekbarColor.setAlpha(255);
                        SpenSettingPenLayout2.this.mBeautifySeekbarColor.setColor(color);
                        SpenSettingPenLayout2.this.mBeautifyAdvanceCursiveSeekbar.invalidate();
                        SpenSettingPenLayout2.this.mBeautifyAdvanceDummySeekbar.invalidate();
                        SpenSettingPenLayout2.this.mBeautifyAdvanceSustenanceSeekbar.invalidate();
                        SpenSettingPenLayout2.this.mBeautifyAdvanceModulationSeekbar.invalidate();
                        if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                            if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getPenAttribute(1)) {
                                info.color = ((SpenSettingPenLayout2.this.mPenAlpha << 24) & (-16777216)) | (16777215 & color);
                            } else {
                                info.color = color;
                            }
                            SpenSettingPenLayout2.this.mSettingInfo.color = info.color;
                            SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                            SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(info.color);
                            SpenSettingPenLayout2.this.mPenPreview.invalidate();
                            SpenSettingPenLayout2.this.mPenAlphaSeekbarColor.setColor(info.color);
                            SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setColor(info.color);
                            SpenSettingPenLayout2.this.mColorPickerSetting.setColorPickerColor(info.color);
                        }
                    }
                    if (selectedItem == 13) {
                        if (SpenSettingPenLayout2.this.mCanvasView != null) {
                            SpenSettingPenLayout2.this.mPreCanvasPenAction = SpenSettingPenLayout2.this.mCanvasView.getToolTypeAction(2);
                            SpenSettingPenLayout2.this.mPreCanvasFingerAction = SpenSettingPenLayout2.this.mCanvasView.getToolTypeAction(1);
                            SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(2, 5);
                            SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(1, 5);
                        }
                        SpenSettingPenLayout2.this.mColorPaletteView.setColorPickerMode();
                        SpenSettingPenLayout2.mColorPickerShow = true;
                        if (!SpenSettingTextLayout2.mColorPickerShow) {
                            SpenSettingPenLayout2.this.mColorPickerSetting.show();
                            if (!SpenSettingPenLayout2.this.mFirstTimeColorPickerShow) {
                                SpenSettingPenLayout2.this.mColorPickerSetting.movePosition(SpenSettingPenLayout2.this.mCanvasLayout.getWidth() / 2, SpenSettingPenLayout2.this.mCanvasLayout.getHeight() / 2);
                                SpenSettingPenLayout2.this.mFirstTimeColorPickerShow = true;
                            }
                        }
                    }
                }
            }
        };
        this.mColorPickerColorChangeListener = new SpenColorGradationView2.onColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.4
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorGradationView2.onColorChangedListener
            public void onColorChanged(int color, int x, int y) {
                SpenSettingPenInfo info;
                int penPluginIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout2.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null) {
                    SpenSettingPenLayout2.this.mPenSizeSeekbarColor.setColor(color);
                    SpenSettingPenLayout2.this.mPenSizeSeekbarColor.setAlpha(255);
                    SpenSettingPenLayout2.this.mBeautifySeekbarColor.setColor(color);
                    SpenSettingPenLayout2.this.mBeautifyAdvanceCursiveSeekbar.invalidate();
                    SpenSettingPenLayout2.this.mBeautifyAdvanceDummySeekbar.invalidate();
                    SpenSettingPenLayout2.this.mBeautifyAdvanceSustenanceSeekbar.invalidate();
                    SpenSettingPenLayout2.this.mBeautifyAdvanceModulationSeekbar.invalidate();
                    if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                        if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                            info.color = ((SpenSettingPenLayout2.this.mPenAlpha << 24) & (-16777216)) | (16777215 & color);
                        } else {
                            info.color = color;
                        }
                        SpenSettingPenLayout2.this.mSettingInfo.color = info.color;
                        SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                        SpenSettingPenLayout2.this.mPenAlphaSeekbarColor.setColor(info.color);
                        SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(info.color);
                        SpenSettingPenLayout2.this.mPenPreview.invalidate();
                        SpenSettingPenLayout2.this.mColorPaletteView.setColor(info.color);
                        SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(info.color);
                        SpenSettingPenLayout2.this.mColorPickerSetting.setColorPickerColor(info.color);
                    }
                }
            }
        };
        this.handler = new Handler();
        this.mPenAlphaChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.5
            int oldProgress = -1;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout2.this.isMagicPenEnable) {
                    SpenSettingPenLayout2.this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingPenLayout2.this.alphaDrawable.setAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                        }
                    });
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout2.this.isMagicPenEnable) {
                    SpenSettingPenLayout2.this.alphaDrawable.setAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingPenInfo info;
                int penPluginIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout2.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null && seekBar == SpenSettingPenLayout2.this.mPenAlphaSeekbar && this.oldProgress != progress) {
                    if (SpenSettingPenLayout2.this.mPenAlphaPreview.getVisibility() == 0) {
                        SpenSettingPenLayout2.this.mPenAlphaPreview.setAlpha((float) (progress / 100.0d));
                    }
                    SpenSettingPenLayout2.this.mPenAlphaTextView.setText(String.valueOf(String.valueOf(progress + 1)) + "%");
                    int seek_label_pos = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(43.0f) + ((int) (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(193.0f) * (progress / 99.0f)));
                    SpenSettingPenLayout2.this.mPenAlphaSeekbar.setContentDescription(String.valueOf(SpenSettingPenLayout2.this.mPenAlphaTextView.getText().toString()) + "\u0000");
                    SpenSettingPenLayout2.this.mPenAlphaTextView.setX(seek_label_pos);
                    SpenSettingPenLayout2.this.mPenAlphaTextView.setY(SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                    this.oldProgress = progress;
                    if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                        if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                            SpenSettingPenLayout2.this.mPenAlpha = Math.round((progress * 255.0f) / 99.0f);
                            SpenSettingPenLayout2.this.mPenPreview.setStrokeAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                            SpenSettingPenLayout2.this.mPenPreview.invalidate();
                            info.color = ((SpenSettingPenLayout2.this.mPenAlpha << 24) & (-16777216)) | (info.color & 16777215);
                            SpenSettingPenLayout2.this.mPenAlphaSeekbarColor.setColor(info.color);
                            SpenSettingPenLayout2.this.mSettingInfo.color = info.color;
                        }
                        SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                        SpenSettingPenLayout2.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(info.color);
                    }
                    if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.getProgress() == SpenSettingPenLayout2.this.mPenAlphaSeekbar.getMax()) {
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setAlpha(0.2f);
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setSelected(false);
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setEnabled(false);
                        if (SpenSettingPenLayout2.this.mPenAlphaAutoIncrement) {
                            SpenSettingPenLayout2.this.mPenAlphaAutoIncrement = false;
                        }
                    } else {
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setAlpha(1.0f);
                        SpenSettingPenLayout2.this.mOpacityPlusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.getProgress() == 0) {
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setAlpha(0.2f);
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setSelected(false);
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setEnabled(false);
                        if (SpenSettingPenLayout2.this.mPenAlphaAutoDecrement) {
                            SpenSettingPenLayout2.this.mPenAlphaAutoDecrement = false;
                        }
                    } else {
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setAlpha(1.0f);
                        SpenSettingPenLayout2.this.mOpacityMinusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout2.this.isMagicPenEnable) {
                        if (SpenSettingPenLayout2.this.alphaDrawable != null) {
                            SpenSettingPenLayout2.this.alphaDrawable.setAlpha(SpenSettingPenLayout2.this.mPenAlpha);
                        }
                        SpenSettingPenLayout2.this.mPenAlphaSeekbarColor.setColor(0);
                    }
                }
            }
        };
        this.mPenSizeChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject() != null) {
                    float min = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                    float max = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMaxSettingValue();
                    if (SpenSettingPenLayout2.this.mPenAlphaPreview.getVisibility() == 0) {
                        float mAlphaWidth = (float) (2.7d + ((progress * 6.3d) / 140.0d));
                        RelativeLayout.LayoutParams penPreviewLayoutParams02 = new RelativeLayout.LayoutParams(-1, SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(mAlphaWidth));
                        penPreviewLayoutParams02.addRule(9);
                        penPreviewLayoutParams02.addRule(12);
                        penPreviewLayoutParams02.rightMargin = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(3.0f);
                        penPreviewLayoutParams02.leftMargin = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(2.0f);
                        penPreviewLayoutParams02.bottomMargin = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(9.5f - (mAlphaWidth / 2.0f));
                        SpenSettingPenLayout2.this.mPenAlphaPreview.setLayoutParams(penPreviewLayoutParams02);
                    }
                    SpenSettingPenLayout2.this.mPenSizeTextView.setText(String.valueOf((((int) min) * 10) + progress));
                    int seek_label_pos = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(45.0f) + ((int) (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(197.0f) * (progress / ((max - min) * 10.0f))));
                    if ((((int) min) * 10) + progress >= 100) {
                        seek_label_pos = SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(42.0f) + ((int) (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(197.0f) * (progress / ((max - min) * 10.0f))));
                    }
                    SpenSettingPenLayout2.this.mPenSizeSeekbar.setContentDescription(String.valueOf(SpenSettingPenLayout2.this.mPenSizeTextView.getText().toString()) + "\u0000");
                    SpenSettingPenLayout2.this.mPenSizeTextView.setX(seek_label_pos);
                    SpenSettingPenLayout2.this.mPenSizeTextView.setY(SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                    if (SpenSettingPenLayout2.this.mCanvasView != null) {
                        if (SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight()) {
                            SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight();
                        }
                        if (SpenSettingPenLayout2.this.mCanvasSize == 0) {
                            SpenSettingPenLayout2.this.mCanvasSize = 1080;
                        }
                    } else {
                        SpenSettingPenLayout2.this.mCanvasSize = 1080;
                    }
                    SpenSettingPenLayout2.this.mSettingInfo.size = (((progress / 10.0f) + min) * SpenSettingPenLayout2.this.mCanvasSize) / 360.0f;
                    SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                    SpenSettingPenLayout2.this.mPenPreview.invalidate();
                    if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                        info.size = SpenSettingPenLayout2.this.mSettingInfo.size;
                        SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                    }
                    if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() == SpenSettingPenLayout2.this.mPenSizeSeekbar.getMax()) {
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setAlpha(0.2f);
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setSelected(false);
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setEnabled(false);
                        if (SpenSettingPenLayout2.this.mPenSizeAutoIncrement) {
                            SpenSettingPenLayout2.this.mPenSizeAutoIncrement = false;
                        }
                    } else {
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setAlpha(1.0f);
                        SpenSettingPenLayout2.this.mPenSizePlusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() == 0) {
                        SpenSettingPenLayout2.this.mPenSizeMinusButton.setAlpha(0.2f);
                        SpenSettingPenLayout2.this.mPenSizeMinusButton.setSelected(false);
                        SpenSettingPenLayout2.this.mPenSizeMinusButton.setEnabled(false);
                        if (SpenSettingPenLayout2.this.mPenSizeAutoDecrement) {
                            SpenSettingPenLayout2.this.mPenSizeAutoDecrement = false;
                            return;
                        }
                        return;
                    }
                    SpenSettingPenLayout2.this.mPenSizeMinusButton.setAlpha(1.0f);
                    SpenSettingPenLayout2.this.mPenSizeMinusButton.setEnabled(true);
                }
            }
        };
        this.mPenSizePlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout2.this.mPenSizeAutoIncrement = true;
                SpenSettingPenLayout2.this.mPenSizePlusButton.setSelected(true);
                SpenSettingPenLayout2.this.repeatUpdateHandler.post(SpenSettingPenLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mPenTypeTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 1) {
                    if (!SpenSettingPenLayout2.this.isPresetClicked) {
                        float x = event.getX();
                        float y = event.getY();
                        int index = (int) (((x - ((SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(65.0f) / SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(89.0f)) * (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(89.0f) - y))) + SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(21.0f)) / SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(56.0f));
                        if (index < 0) {
                            index = 0;
                        } else if (index > SpenSettingPenLayout2.this.mPenTypeView.size() - 1) {
                            index = SpenSettingPenLayout2.this.mPenTypeView.size() - 1;
                        }
                        if (index < SpenSettingPenLayout2.this.mNumberOfPenExist) {
                            View v1 = SpenSettingPenLayout2.this.localPenTypeViewGroup.getChildAt(index);
                            for (int i = 0; i < SpenSettingPenLayout2.this.mPenTypeView.size(); i++) {
                                if (v1 == SpenSettingPenLayout2.this.mPenTypeView.get(i)) {
                                    SpenSettingPenLayout2.this.penSelectIndex(i);
                                }
                            }
                            SpenSettingPenLayout2.this.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                } else {
                    SpenSettingPenLayout2.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mPenTypeHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.9
            private int preIndex = 0;

            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                int index = (int) (((x - ((SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(65.0f) / SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(89.0f)) * (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(89.0f) - y))) + SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(21.0f)) / SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(56.0f));
                if (index < 0) {
                    index = 0;
                } else if (index > SpenSettingPenLayout2.this.mPenTypeView.size() - 1) {
                    index = SpenSettingPenLayout2.this.mPenTypeView.size() - 1;
                }
                if (this.preIndex < 0) {
                    this.preIndex = 0;
                } else if (this.preIndex > SpenSettingPenLayout2.this.mPenTypeView.size() - 1) {
                    this.preIndex = SpenSettingPenLayout2.this.mPenTypeView.size() - 1;
                }
                if (index != this.preIndex) {
                    event.setAction(10);
                    SpenSettingPenLayout2.this.mPenTypeView.get(this.preIndex).dispatchGenericMotionEvent(event);
                    event.setAction(9);
                    SpenSettingPenLayout2.this.mPenTypeView.get(index).sendAccessibilityEvent(128);
                }
                SpenSettingPenLayout2.this.mPenTypeView.get(index).dispatchGenericMotionEvent(event);
                this.preIndex = index;
                return true;
            }
        };
        this.mPenSizePlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout2.this.mPenSizeAutoIncrement) {
                    SpenSettingPenLayout2.this.mPenSizePlusButton.setSelected(false);
                    SpenSettingPenLayout2.this.mPenSizeAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPenSizeMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout2.this.mPenSizeAutoDecrement = true;
                SpenSettingPenLayout2.this.mPenSizeMinusButton.setSelected(true);
                SpenSettingPenLayout2.this.repeatUpdateHandler.post(SpenSettingPenLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mPenSizeMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout2.this.mPenSizeAutoDecrement) {
                    SpenSettingPenLayout2.this.mPenSizeMinusButton.setSelected(false);
                    SpenSettingPenLayout2.this.mPenSizeAutoDecrement = false;
                }
                return false;
            }
        };
        this.mPenAlphaPlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout2.this.mPenAlphaAutoIncrement = true;
                SpenSettingPenLayout2.this.mOpacityPlusButton.setSelected(true);
                SpenSettingPenLayout2.this.repeatUpdateHandler.post(SpenSettingPenLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mPenAlphaPlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout2.this.mPenAlphaAutoIncrement) {
                    SpenSettingPenLayout2.this.mOpacityPlusButton.setSelected(false);
                    SpenSettingPenLayout2.this.mPenAlphaAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPenAlphaMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.15
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout2.this.mPenAlphaAutoDecrement = true;
                SpenSettingPenLayout2.this.mOpacityMinusButton.setSelected(true);
                SpenSettingPenLayout2.this.repeatUpdateHandler.post(SpenSettingPenLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mPenAlphaMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout2.this.mPenAlphaAutoDecrement) {
                    SpenSettingPenLayout2.this.mOpacityMinusButton.setSelected(false);
                    SpenSettingPenLayout2.this.mPenAlphaAutoDecrement = false;
                }
                return false;
            }
        };
        this.mPenSizePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(1);
                float min = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    if (SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight()) {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth();
                    } else {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight();
                    }
                    if (SpenSettingPenLayout2.this.mCanvasSize == 0) {
                        SpenSettingPenLayout2.this.mCanvasSize = 1080;
                    }
                } else {
                    SpenSettingPenLayout2.this.mCanvasSize = 1080;
                }
                SpenSettingPenLayout2.this.mSettingInfo.size = (((SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout2.this.mCanvasSize) / 360.0f;
                SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout2.this.mSettingInfo.size);
            }
        };
        this.mPenSizeMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() > 0) {
                    SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(-1);
                }
                float min = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    if (SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight()) {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasWidth();
                    } else {
                        SpenSettingPenLayout2.this.mCanvasSize = SpenSettingPenLayout2.this.mCanvasView.getCanvasHeight();
                    }
                    if (SpenSettingPenLayout2.this.mCanvasSize == 0) {
                        SpenSettingPenLayout2.this.mCanvasSize = 1080;
                    }
                } else {
                    SpenSettingPenLayout2.this.mCanvasSize = 1080;
                }
                SpenSettingPenLayout2.this.mSettingInfo.size = (((SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout2.this.mCanvasSize) / 360.0f;
                if (SpenSettingPenLayout2.this.mSettingInfo.size >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                } else {
                    SpenSettingPenLayout2.this.mSettingInfo.size = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                }
            }
        };
        this.mPenAlphaPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(1);
            }
        };
        this.mPenAlphaMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(-1);
            }
        };
        this.mPaletteNextButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int index = SpenSettingPenLayout2.this.colorPaletteView.getCurrentTableIndex();
                if (index == 3) {
                    SpenSettingPenLayout2.this.mPaletteLeftButton.setAlpha(1.0f);
                    SpenSettingPenLayout2.this.mPaletteLeftButton.setEnabled(true);
                }
                SpenSettingPenLayout2.this.colorPaletteView.setNextColorTable(index);
                SpenSettingPenLayout2.this.mColorPaletteView.setSelectBoxPos(SpenSettingPenLayout2.this.mSettingInfo.color);
                if (SpenSettingPenLayout2.this.colorPaletteView.getCurrentTableIndex() == 2) {
                    SpenSettingPenLayout2.this.mPaletteRightButton.setAlpha(0.2f);
                    SpenSettingPenLayout2.this.mPaletteRightButton.setEnabled(false);
                }
            }
        };
        this.mPaletteBackButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int index = SpenSettingPenLayout2.this.colorPaletteView.getCurrentTableIndex();
                if (index == 2) {
                    SpenSettingPenLayout2.this.mPaletteRightButton.setAlpha(1.0f);
                    SpenSettingPenLayout2.this.mPaletteRightButton.setEnabled(true);
                }
                SpenSettingPenLayout2.this.colorPaletteView.setBackColorTable(index);
                SpenSettingPenLayout2.this.mColorPaletteView.setSelectBoxPos(SpenSettingPenLayout2.this.mSettingInfo.color);
                if (SpenSettingPenLayout2.this.colorPaletteView.getCurrentTableIndex() == 3) {
                    SpenSettingPenLayout2.this.mPaletteLeftButton.setAlpha(0.2f);
                    SpenSettingPenLayout2.this.mPaletteLeftButton.setEnabled(false);
                }
            }
        };
        this.mPenTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws NumberFormatException {
                SpenSettingPenLayout2.this.penSelection(v);
            }
        };
        this.mColorPickerCurrentColorListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                    SpenSettingPenLayout2.this.mSettingInfo.color = info.color;
                    SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(info.color);
                    SpenSettingPenLayout2.this.mPenPreview.invalidate();
                    SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                }
                SpenSettingPenLayout2.this.mColorPaletteView.setColor(SpenSettingPenLayout2.this.mSettingInfo.color);
                SpenSettingPenLayout2.this.mColorPaletteView.invalidate();
                if (SpenSettingPenLayout2.this.mCanvasView != null) {
                    SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(2, SpenSettingPenLayout2.this.mPreCanvasPenAction);
                    SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(1, SpenSettingPenLayout2.this.mPreCanvasFingerAction);
                }
                SpenSettingPenLayout2.mColorPickerShow = false;
                SpenSettingPenLayout2.this.mColorPickerSetting.hide();
                SpenSettingPenLayout2.this.setVisibility(0);
            }
        };
        this.mPopupButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SpenSettingPenLayout2.this.mPopupMaxButton) {
                    if (SpenSettingPenLayout2.this.mPopupListener != null) {
                        SpenSettingPenLayout2.this.mPopupListener.onPopup(true);
                    }
                } else if (v == SpenSettingPenLayout2.this.mPopupMinButton && SpenSettingPenLayout2.this.mPopupListener != null) {
                    SpenSettingPenLayout2.this.mPopupListener.onPopup(false);
                }
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    if (SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor() != 0) {
                        if (SpenSettingPenLayout2.this.mCanvasView != null) {
                            SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(2, SpenSettingPenLayout2.this.mPreCanvasPenAction);
                            SpenSettingPenLayout2.this.mCanvasView.setToolTypeAction(1, SpenSettingPenLayout2.this.mPreCanvasFingerAction);
                        }
                        SpenSettingPenLayout2.this.mPenPreview.setStrokeColor(SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor());
                        SpenSettingPenLayout2.this.mPenPreview.invalidate();
                        SpenSettingPenLayout2.this.mSettingInfo.color = SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor();
                        if (SpenSettingPenLayout2.this.mCanvasView != null && (info = SpenSettingPenLayout2.this.mCanvasView.getPenSettingInfo()) != null) {
                            info.color = SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor();
                            SpenSettingPenLayout2.this.mCanvasView.setPenSettingInfo(info);
                        }
                        SpenSettingPenLayout2.this.mColorPaletteView.setColorPickerColor(SpenSettingPenLayout2.this.mColorPickerSetting.getColorPickerCurrentColor());
                        SpenSettingPenLayout2.this.mColorPaletteView.invalidate();
                    }
                    SpenSettingPenLayout2.this.mColorPickerSetting.hide();
                }
                if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject() != null && SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().getPenAttribute(4)) {
                    SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().hideAdvancedSetting();
                    SpenSettingPenLayout2.this.mAdvancedSettingShow = false;
                }
                SpenSettingPenLayout2.mColorPickerShow = false;
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingPenLayout2.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mOnConsumedHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.28
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                return true;
            }
        };
        this.mAdvancedSettingButtonListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject() != null) {
                    if (!SpenSettingPenLayout2.this.mAdvancedSettingShow) {
                        SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().showAdvancedSetting(SpenSettingPenLayout2.this.mContext, SpenSettingPenLayout2.this.mAdvancedSettingListener, (ViewGroup) SpenSettingPenLayout2.this.getParent());
                    } else {
                        SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenPluginObject().hideAdvancedSetting();
                    }
                    SpenSettingPenLayout2.this.mAdvancedSettingShow = !SpenSettingPenLayout2.this.mAdvancedSettingShow;
                }
            }
        };
        this.mPreSetAddButtonListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Resources.NotFoundException {
                if (SpenSettingPenLayout2.mPresetInfoList == null) {
                    SpenSettingPenLayout2.mPresetInfoList = new ArrayList();
                }
                if (SpenSettingPenLayout2.mPresetInfoList.size() >= 36) {
                    String strPreset = SpenSettingPenLayout2.this.mStringUtil.setString("string_reached_maximum_preset");
                    if (strPreset != null) {
                        CharSequence text = String.format(strPreset, 36);
                        Toast toast = Toast.makeText(SpenSettingPenLayout2.this.mContext, text, 0);
                        toast.show();
                        return;
                    }
                    return;
                }
                for (SpenPenPresetInfo info : SpenSettingPenLayout2.mPresetInfoList) {
                    if (info.getPenName().equals(SpenSettingPenLayout2.this.mSettingInfo.name) && info.getPenSize() == SpenSettingPenLayout2.this.mSettingInfo.size && info.getColor() == SpenSettingPenLayout2.this.mSettingInfo.color && info.getAdvancedSetting().equals(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting)) {
                        CharSequence text2 = SpenSettingPenLayout2.this.mStringUtil.setString("string_already_exists");
                        Toast toast2 = Toast.makeText(SpenSettingPenLayout2.this.mContext, text2, 0);
                        toast2.show();
                        return;
                    }
                }
                SpenPenPresetInfo presetInfoItem = new SpenPenPresetInfo();
                presetInfoItem.setPenName(SpenSettingPenLayout2.this.mSettingInfo.name);
                presetInfoItem.setBitmapSize(SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(65.0f), SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(65.0f));
                presetInfoItem.setPenSize(SpenSettingPenLayout2.this.mSettingInfo.size);
                presetInfoItem.setColor(SpenSettingPenLayout2.this.mSettingInfo.color);
                presetInfoItem.setAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                presetInfoItem.setPresetImageName(SpenSettingPenLayout2.this.mPresetListAdapter.getPresetImage(SpenSettingPenLayout2.this.mSettingInfo.name));
                SpenSettingPenLayout2.mPresetInfoList.add(presetInfoItem);
                SpenSettingPenLayout2.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout2.mPresetInfoList.size() - 1;
                SpenSettingPenLayout2.this.mPreviousSelectedPresetIndex = SpenSettingPenLayout2.mPresetInfoList.size() - 1;
                SpenSettingPenLayout2.this.mPresetListAdapter.notifyDataSetChanged();
                SpenSettingPenLayout2.this.presetDisplay();
                if (SpenSettingPenLayout2.this.mPresetListener != null) {
                    SpenSettingPenLayout2.this.mPresetListener.onAdded(SpenSettingPenLayout2.this.mSettingInfo);
                }
                SpenSettingPenLayout2.this.mPresetGridView.smoothScrollToPosition(SpenSettingPenLayout2.mPresetInfoList.size() - 1);
            }
        };
        this.mExpendBarListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.31
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingPenLayout2.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mBeautifyEnablecheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.32
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) throws NumberFormatException {
                SpenSettingPenLayout2.this.showBeautifySettingViews(isChecked);
                if (SpenSettingPenLayout2.this.isChinesePen(SpenSettingPenLayout2.this.mSettingInfo.name) || SpenSettingPenLayout2.this.isBeautifyPen(SpenSettingPenLayout2.this.mSettingInfo.name)) {
                    if (isChecked) {
                        SpenSettingPenLayout2.this.mPenNameIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout2.BEAUTIFY_PEN_NAME);
                    } else {
                        SpenSettingPenLayout2.this.mPenNameIndex = SpenSettingPenLayout2.this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                    }
                    SpenSettingPenLayout2.this.mSettingInfo.name = SpenSettingPenLayout2.this.mPenPluginInfoList.get(SpenSettingPenLayout2.this.mPenNameIndex).getPenName();
                    SpenSettingPenLayout2.this.updateBeautifySettingData();
                    SpenSettingPenLayout2.this.beautifyUpdateSettingUI(isChecked);
                    SpenSettingPenLayout2.this.drawExpendImage(SpenSettingPenLayout2.this.mSettingInfo.name);
                }
            }
        };
        this.mBeautifyStyleBtnsListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout2.this.mBeautifyStyleBtnViews != null) {
                    int beautifyStyleIndex = 0;
                    Iterator<ImageButton> it = SpenSettingPenLayout2.this.mBeautifyStyleBtnViews.iterator();
                    while (it.hasNext()) {
                        ImageButton styleBtn = it.next();
                        if (styleBtn.equals(v)) {
                            if (beautifyStyleIndex == SpenSettingPenLayout2.this.mCurrentBeautifyStyle) {
                                break;
                            }
                            SpenSettingPenLayout2.this.mCurrentBeautifyStyle = beautifyStyleIndex;
                            styleBtn.setSelected(true);
                        } else {
                            styleBtn.setSelected(false);
                        }
                        beautifyStyleIndex++;
                    }
                    SpenSettingPenLayout2.this.resetBeautifyAdvanceDataAndUpdateSeekBarUi(SpenSettingPenLayout2.this.mCurrentBeautifyStyle);
                }
            }
        };
        this.mBeautifyAdvanceCursiveChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.34
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String cursiveStr = String.valueOf(SpenSettingPenLayout2.this.mStringUtil.setString("string_cursive")) + " " + progress;
                SpenSettingPenLayout2.this.mBeautifyCursiveTextView.setText(cursiveStr);
                SpenSettingPenLayout2.this.setBeautifyAdvancedDataToPlugin(2, progress);
                SpenSettingPenLayout2.this.updateBeautifySettingData();
                SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout2.this.mPenPreview.invalidate();
            }
        };
        this.mBeautifyAdvanceSustenanceChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.35
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String sustenanceStr = String.valueOf(SpenSettingPenLayout2.this.mSustenanceStr) + " " + progress;
                SpenSettingPenLayout2.this.mBeautifySustenanceTextView.setText(sustenanceStr);
                SpenSettingPenLayout2.this.setBeautifyAdvancedDataToPlugin(3, progress);
                SpenSettingPenLayout2.this.updateBeautifySettingData();
                SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout2.this.mPenPreview.invalidate();
            }
        };
        this.mBeautifyAdvanceDummyChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.36
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String dummyStr = String.valueOf(SpenSettingPenLayout2.this.mStringUtil.setString("string_dummy")) + " " + progress;
                SpenSettingPenLayout2.this.mBeautifyDummyTextView.setText(dummyStr);
                SpenSettingPenLayout2.this.setBeautifyAdvancedDataToPlugin(4, progress);
                SpenSettingPenLayout2.this.updateBeautifySettingData();
                SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout2.this.mPenPreview.invalidate();
            }
        };
        this.mBeautifyAdvanceModulationChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.37
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String modulationStr = String.valueOf(SpenSettingPenLayout2.this.mStringUtil.setString("string_modulation")) + " " + progress;
                SpenSettingPenLayout2.this.mBeautifyModulationTextView.setText(modulationStr);
                SpenSettingPenLayout2.this.setBeautifyAdvancedDataToPlugin(6, progress);
                SpenSettingPenLayout2.this.updateBeautifySettingData();
                SpenSettingPenLayout2.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout2.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout2.this.mPenPreview.invalidate();
            }
        };
        this.mBeautifyAdvanceCursivePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceCursiveMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceSustenancePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceSustenanceMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceDummyPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.42
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceDummyMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.43
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceModulationPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.44
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceModulationMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.45
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceResetButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout2.this.resetBeautifyAdvanceDataAndUpdateSeekBarUi(SpenSettingPenLayout2.this.mCurrentBeautifyStyle);
            }
        };
        this.mPenSizeKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.47
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout2.this.mPenSizeSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout2.this.mPenSizeSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout2.this.mPenSizeSeekbar.getProgress() != SpenSettingPenLayout2.this.mPenSizeSeekbar.getMax()) {
                                SpenSettingPenLayout2.this.mPenSizeSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mPenAlphaKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.48
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout2.this.mPenAlphaSeekbar.getProgress() != SpenSettingPenLayout2.this.mPenAlphaSeekbar.getMax()) {
                                SpenSettingPenLayout2.this.mPenAlphaSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.horizontalScrollViewTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.49
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() != 1 || SpenSettingPenLayout2.this.mPenTypeHorizontalScrollView2.getScrollX() <= SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(SpenSettingPenLayout2.SUITABLE_WIDTH_IN_ANIMATION_SCROLL)) {
                    return false;
                }
                SpenSettingPenLayout2.this.playScrollAnimation(10, SpenSettingPenLayout2.this.mPenTypeHorizontalScrollView2.getScrollX(), SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(SpenSettingPenLayout2.SUITABLE_WIDTH_IN_ANIMATION_SCROLL));
                return false;
            }
        };
        this.deltaOfMiniMode = 0;
        this.isMinimumMode = false;
        this.mNumberOfPenExist = 6;
        this.mScrollViewListner = new SpenScrollView.scrollChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.50
            @Override // com.samsung.android.sdk.pen.settingui.SpenScrollView.scrollChangedListener
            public void scrollChanged(int scrollY) {
                RelativeLayout.LayoutParams PaletteBgParam;
                SpenSettingPenLayout2.this.mScrollY = scrollY;
                if (SpenSettingPenLayout2.this.mPenAlphaSeekbarView.getVisibility() == 0) {
                    PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(163.0f) - (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(428.0f) - SpenSettingPenLayout2.this.mBodyLayoutHeight)) + SpenSettingPenLayout2.this.mScrollY);
                } else {
                    PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(163.0f) - (SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(366.0f) - SpenSettingPenLayout2.this.mBodyLayoutHeight)) + SpenSettingPenLayout2.this.mScrollY);
                }
                PaletteBgParam.setMargins(0, 0, SpenSettingPenLayout2.this.mDrawableImg.getIntValueAppliedDensity(-1.5f), 0);
                if (PaletteBgParam.height >= 0) {
                    SpenSettingPenLayout2.this.mPaletteBg.setLayoutParams(PaletteBgParam);
                }
            }
        };
        this.mBeautifyStr = Beautify.TAG;
        this.mSustenanceStr = "Sustenance";
        this.mCurrentBeautifyAdvanceSettingValues = new int[][]{new int[]{11, 2, 5, 8, 1, 15, 70, 11, 0, 1}, new int[]{12, 2, 5, 1, 1, 18, 70, 13, 0, 1}, new int[]{5, 2, 2, 2, 1, 18, 70, 5, 0, 1}, new int[]{6, 2, 3, 3, 1, 12, 70, 6, 0, 1}, new int[]{1, 2, 2, 8, 1, 15, 70, 3, 0, 1}, new int[]{3, 1, 3, 5, 1, 12, 70, 1, 0, 1}};
        mScale = ratio;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, ratio);
        this.mStringUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mContext = context;
        this.mCanvasLayout = relativeLayout;
        this.mBodyLayoutHeight = -2;
        this.mPluginManager = SpenPluginManager.getInstance(context);
        if (this.mPluginManager != null) {
            initPenPlugin(context);
        }
        this.mSupportBeautifyPen = false;
        this.mSettingInfo = new SpenSettingPenInfo();
        initButtonValue();
        initView(customImagePath);
        setListener();
        this.mMovableRect = new Rect();
    }

    private void totalLayout() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), -2);
        setLayoutParams(layoutParams);
        setOrientation(1);
        this.mTitleLayout = titleLayout();
        this.mBodyLayout = bodyLayout();
        this.mBodyLayout2 = bodyLayout2();
        addView(this.mTitleLayout);
        addView(this.mBodyLayout);
        addView(this.mBodyLayout2);
    }

    private ViewGroup titleLayout() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        layout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(41.0f)));
        this.mPopupMaxButton = popupMaxButton();
        this.mPopupMinButton = popupMinButton();
        this.mLine2Button = lineButton2();
        this.mPresetAddButton = presetAddButton();
        this.mLine1Button = lineButton1();
        layout.addView(titleBg());
        layout.addView(titleText());
        layout.addView(this.mLine1Button);
        layout.addView(this.mLine2Button);
        layout.addView(this.mPopupMaxButton);
        layout.addView(this.mPopupMinButton);
        layout.addView(this.mPresetAddButton);
        this.mPopupMaxButton.setVisibility(8);
        return layout;
    }

    private View titleBg() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ImageView titleBg = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleBgParam = new RelativeLayout.LayoutParams(-1, -1);
        titleBgParam.alignWithParent = true;
        titleBgParam.addRule(9);
        titleBgParam.addRule(10);
        titleBg.setLayoutParams(titleBgParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(titleBg, titleLeftPath);
        ImageView titleRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.3f), -1);
        titleRightParam.alignWithParent = true;
        titleRightParam.addRule(11);
        titleRightParam.addRule(10);
        titleRight.setLayoutParams(titleRightParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(titleBg, titleLeftPath);
        relativeLayout.addView(titleBg);
        relativeLayout.setOnHoverListener(this.mOnConsumedHoverListener);
        return relativeLayout;
    }

    private RelativeLayout bodyLayout() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), -2);
        layout.setLayoutParams(layoutParams);
        this.mPenLayout = penLayout();
        this.mBodyBg = bodyBg();
        layout.addView(this.mBodyBg);
        layout.addView(this.mPenLayout);
        this.mBottomLayout = bottomLayout();
        this.mBottomLayout.setContentDescription(this.mStringUtil.setString("string_resize"));
        layout.addView(this.mBottomLayout);
        this.mBottomLayout.setVisibility(4);
        presetTypeButton();
        presetLayout();
        return layout;
    }

    private RelativeLayout bodyLayout2() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        layout.setLayoutParams(new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), this.mDrawableImg.getIntValueAppliedDensity(200.0f)));
        layout.addView(bodyBg());
        layout.addView(typeSelectorlayout2());
        layout.addView(presetLayout());
        return layout;
    }

    private void initButtonValue() {
        this.EXIT_BUTTON_WIDTH = 42;
        this.EXIT_BUTTON_HEIGHT = 42;
        this.LINE_BUTTON_TOP_MARGIN = 17.0f - ((mScale - 1.0f) * 2.0f);
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

    public void close() throws IOException {
        savePreferences();
        if (this.mDrawableImg != null) {
            for (int i = 0; i < this.mPenPluginCount; i++) {
                this.mSettingInfo.name = this.mPenPluginInfoList.get(i).getPenName();
                if (this.mPenPluginInfoList.get(i).getPenPluginObject() != null) {
                    this.mPenPluginInfoList.get(i).getPenPluginObject().setBitmap(null);
                    this.mPluginManager.unloadPlugin(this.mPenPluginInfoList.get(i).getPenPluginObject());
                }
            }
            this.mDrawableImg.unbindDrawables(this);
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
                for (int i2 = 0; i2 < this.mBeautifyStyleBtnViews.size(); i2++) {
                    ImageButton styleBtn = this.mBeautifyStyleBtnViews.get(i2);
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
            if (this.mPresetListAdapter != null) {
                this.mPresetListAdapter.close();
                this.mPresetListAdapter = null;
            }
            if (this.mPenPluginInfoList != null) {
                this.mPenPluginInfoList.clear();
                this.mPenPluginInfoList = null;
            }
            if (this.mPresetDataList != null) {
                this.mPresetDataList.clear();
                this.mPresetDataList = null;
            }
            if (mPresetInfoList != null) {
                for (int i3 = 0; i3 < mPresetInfoList.size(); i3++) {
                    SpenPenPresetInfo presetInfo = mPresetInfoList.get(i3);
                    presetInfo.close();
                }
                mPresetInfoList.clear();
                mPresetInfoList = null;
            }
            if (this.mPenDataList != null) {
                this.mPenDataList.clear();
                this.mPenDataList = null;
            }
            mDefaultPath = null;
            this.mPenSizeSeekbarColor = null;
            this.mBeautifySeekbarColor = null;
            this.mPenAlphaSeekbarColor = null;
            this.mPresetListener = null;
            this.mActionListener = null;
            this.mSettingInfo = null;
            this.mContext = null;
            this.mCanvasLayout = null;
            this.mCanvasView = null;
            this.mDrawableImg.unbindDrawables(this);
            this.mDrawableImg = null;
            this.mImageLoader.close();
            this.mImageLoader = null;
            mColorPickerShow = false;
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
        if (this.mPresetDataList == null) {
            this.mPresetDataList = new ArrayList();
        }
        this.mPresetListAdapter = new SpenPenPresetListAdapter(this.mContext, 0, mPresetInfoList, customImagePath, this.mPenPluginInfoList, mScale);
        this.mPresetListAdapter.setPenPlugin(this.mPenPluginManager);
        totalLayout();
        findMinValue(this.titleTextView, this.mDrawableImg.getIntValueAppliedDensity((329 - (this.EXIT_BUTTON_WIDTH * 2)) - 8));
        if (this.mPresetGridView != null) {
            this.mPresetGridView.setAdapter((ListAdapter) this.mPresetListAdapter);
        }
        this.localPenTypeViewGroup = (RelativeLayout) this.mPenTypeHorizontalScrollView.getChildAt(0);
        for (int i = 0; i < this.localPenTypeViewGroup.getChildCount() - 1; i++) {
            this.mPenTypeView.add(this.localPenTypeViewGroup.getChildAt(i));
        }
        showBeautifySettingViews(false);
        initColorSelecteView();
        ColorPickerSettingInit();
        this.mPresetListAdapter.notifyDataSetChanged();
        presetDisplay();
        setVisibility(8);
    }

    public void loadPreferences() {
        if (this.mPenSharedPreferencesManager != null && this.mPenPluginManager != null && this.mPenTypeView != null && this.mSettingInfo != null) {
            String currentPenName = this.mPenSharedPreferencesManager.getCurrentPenName();
            int penTypeViewIndex = this.mPenPluginManager.getPenPluginIndexByPenName(currentPenName);
            if (penTypeViewIndex < 0) {
                this.mPenSharedPreferencesManager.removeCurrentPenData();
                penTypeViewIndex = 1;
            }
            penSelectIndex(penTypeViewIndex);
            this.mPenSharedPreferencesManager.clearSharedPenData();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void savePreferences() throws java.io.IOException {
        /*
            r9 = this;
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            if (r6 == 0) goto L8
            com.samsung.android.sdk.pen.SpenSettingPenInfo r6 = r9.mSettingInfo
            if (r6 != 0) goto L9
        L8:
            return
        L9:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList<com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo> r6 = r9.mPenPluginInfoList
            java.util.Iterator r1 = r6.iterator()
            r3 = 0
        L15:
            java.util.ArrayList<com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo> r6 = r9.mPenPluginInfoList
            int r6 = r6.size()
            if (r3 < r6) goto L48
        L1d:
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            if (r6 == 0) goto L8
            com.samsung.android.sdk.pen.SpenSettingPenInfo r6 = r9.mSettingInfo
            if (r6 == 0) goto L8
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            r6.setPenDataList(r4)
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            com.samsung.android.sdk.pen.SpenSettingPenInfo r7 = r9.mSettingInfo
            java.lang.String r7 = r7.name
            r6.setCurrentPenName(r7)
            java.util.List<com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo> r6 = com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.mPresetInfoList
            if (r6 == 0) goto L8
            r0 = 0
        L38:
            java.util.List<com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo> r6 = com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.mPresetInfoList
            int r6 = r6.size()
            if (r0 < r6) goto L91
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            java.util.List<com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo> r7 = com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.mPresetInfoList
            r6.setPresetData(r7)
            goto L8
        L48:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L1d
            java.lang.Object r5 = r1.next()
            com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo r5 = (com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo) r5
            com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface r6 = r5.getPenPluginObject()
            if (r6 != 0) goto L6e
            com.samsung.android.sdk.pen.settingui.SpenPenPluginManager r6 = r9.mPenPluginManager
            android.content.Context r7 = r9.mContext
            java.lang.String r8 = r5.getPenName()
            r6.loadPenPlugin(r7, r8)
            com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface r6 = r5.getPenPluginObject()
            if (r6 != 0) goto L6e
        L6b:
            int r3 = r3 + 1
            goto L15
        L6e:
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
            goto L6b
        L91:
            java.util.List<com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo> r6 = com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.mPresetInfoList
            java.lang.Object r6 = r6.get(r0)
            com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo r6 = (com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo) r6
            r6.setPresetOrder(r0)
            int r0 = r0 + 1
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.savePreferences():void");
    }

    private void setListener() {
        if (this.mTitleLayout != null) {
            this.mTitleLayout.setOnTouchListener(this.mOnConsumedTouchListener);
            this.mTitleLayout.setOnHoverListener(this.mOnConsumedHoverListener);
        }
        if (this.mPopupMaxButton != null) {
            this.mPopupMaxButton.setOnClickListener(this.mPopupButtonListener);
        }
        if (this.mPopupMinButton != null) {
            this.mPopupMinButton.setOnClickListener(this.mPopupButtonListener);
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
        }
        if (this.mColorGradationView != null) {
            this.mColorGradationView.setColorPickerColorChangeListener(this.mColorPickerColorChangeListener);
        }
        if (this.mBottomLayout != null) {
            this.mBottomLayout.setOnTouchListener(this.mExpendBarListener);
        }
        if (this.mPenSizePlusButton != null) {
            this.mPenSizePlusButton.setOnClickListener(this.mPenSizePlusButtonListener);
            this.mPenSizePlusButton.setOnLongClickListener(this.mPenSizePlusButtonLongClickListener);
            this.mPenSizePlusButton.setOnTouchListener(this.mPenSizePlusButtonTouchListener);
        }
        if (this.mPenSizeMinusButton != null) {
            this.mPenSizeMinusButton.setOnClickListener(this.mPenSizeMinusButtonListener);
            this.mPenSizeMinusButton.setOnLongClickListener(this.mPenSizeMinusButtonLongClickListener);
            this.mPenSizeMinusButton.setOnTouchListener(this.mPenSizeMinusButtonTouchListener);
        }
        if (this.mOpacityPlusButton != null) {
            this.mOpacityPlusButton.setOnClickListener(this.mPenAlphaPlusButtonListener);
            this.mOpacityPlusButton.setOnLongClickListener(this.mPenAlphaPlusButtonLongClickListener);
            this.mOpacityPlusButton.setOnTouchListener(this.mPenAlphaPlusButtonTouchListener);
        }
        if (this.mOpacityMinusButton != null) {
            this.mOpacityMinusButton.setOnClickListener(this.mPenAlphaMinusButtonListener);
            this.mOpacityMinusButton.setOnLongClickListener(this.mPenAlphaMinusButtonLongClickListener);
            this.mOpacityMinusButton.setOnTouchListener(this.mPenAlphaMinusButtonTouchListener);
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
        }
        if (this.mBeautifyAdvanceSustenanceSeekbar != null) {
            this.mBeautifyAdvanceSustenanceSeekbar.setOnSeekBarChangeListener(this.mBeautifyAdvanceSustenanceChangeListner);
        }
        if (this.mBeautifyAdvanceDummySeekbar != null) {
            this.mBeautifyAdvanceDummySeekbar.setOnSeekBarChangeListener(this.mBeautifyAdvanceDummyChangeListner);
        }
        if (this.mBeautifyAdvanceModulationSeekbar != null) {
            this.mBeautifyAdvanceModulationSeekbar.setOnSeekBarChangeListener(this.mBeautifyAdvanceModulationChangeListner);
        }
        if (this.mBeautifyAdvanceCursivePlusButton != null) {
            this.mBeautifyAdvanceCursivePlusButton.setOnClickListener(this.mBeautifyAdvanceCursivePlusButtonListener);
        }
        if (this.mBeautifyAdvanceSustenancePlusButton != null) {
            this.mBeautifyAdvanceSustenancePlusButton.setOnClickListener(this.mBeautifyAdvanceSustenancePlusButtonListener);
        }
        if (this.mBeautifyAdvanceDummyPlusButton != null) {
            this.mBeautifyAdvanceDummyPlusButton.setOnClickListener(this.mBeautifyAdvanceDummyPlusButtonListener);
        }
        if (this.mBeautifyAdvanceModulationPlusButton != null) {
            this.mBeautifyAdvanceModulationPlusButton.setOnClickListener(this.mBeautifyAdvanceModulationPlusButtonListener);
        }
        if (this.mBeautifyAdvanceCursiveMinusButton != null) {
            this.mBeautifyAdvanceCursiveMinusButton.setOnClickListener(this.mBeautifyAdvanceCursiveMinusButtonListener);
        }
        if (this.mBeautifyAdvanceSustenanceMinusButton != null) {
            this.mBeautifyAdvanceSustenanceMinusButton.setOnClickListener(this.mBeautifyAdvanceSustenanceMinusButtonListener);
        }
        if (this.mBeautifyAdvanceDummyMinusButton != null) {
            this.mBeautifyAdvanceDummyMinusButton.setOnClickListener(this.mBeautifyAdvanceDummyMinusButtonListener);
        }
        if (this.mBeautifyAdvanceModulationMinusButton != null) {
            this.mBeautifyAdvanceModulationMinusButton.setOnClickListener(this.mBeautifyAdvanceModulationMinusButtonListener);
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
        this.mColorPickerSetting = new SpenColorPickerLayout2(this.mContext, this.mCanvasLayout, mScale, 0, 0);
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
        setLayoutParams(params);
        if (this.mFirstLongPress) {
            this.mLeftMargin -= x;
            this.mTopMargin -= y;
        }
    }

    private void findMinValue(TextView v, int maxWidth) {
        float currentFloat = 20.0f;
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

    private View titleText() {
        this.titleTextView = new TextView(this.mContext);
        this.titleTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.titleTextView.setTextColor(Color.rgb(250, 250, 250));
        this.titleTextView.setGravity(19);
        this.titleTextView.setFocusable(true);
        this.titleTextView.setSingleLine(true);
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setText(this.mStringUtil.setString("string_pen_settings"));
        this.titleTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(20.0f));
        this.titleTextView.setTypeface(SpenFont.getTypeFace("Roboto-Regular"), 0);
        this.titleTextView.setContentDescription(this.mStringUtil.setString("string_pen_settings"));
        this.titleTextView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(13.0f), 0, 0, 0);
        return this.titleTextView;
    }

    private View popupMaxButton() {
        ImageButton popupMaxButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(42.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        exitButtonParams.addRule(11);
        exitButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(4.0f);
        popupMaxButton.setLayoutParams(exitButtonParams);
        popupMaxButton.setFocusable(true);
        popupMaxButton.setContentDescription(this.mStringUtil.setString("string_close"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(popupMaxButton, popupMaxPath, popupMaxPath, popupMaxPath, 42, 42);
        return popupMaxButton;
    }

    private View popupMinButton() {
        ImageButton popupMinButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(42.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        exitButtonParams.addRule(11);
        exitButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(4.0f);
        popupMinButton.setLayoutParams(exitButtonParams);
        popupMinButton.setFocusable(true);
        popupMinButton.setContentDescription(this.mStringUtil.setString("string_close"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(popupMinButton, popupMinPath, popupMinPath, popupMinPath, 42, 42);
        return popupMinButton;
    }

    private View presetAddButton() {
        ImageButton presetButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams presetButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(42.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        presetButtonParams.addRule(11);
        presetButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(42.0f);
        presetButton.setLayoutParams(presetButtonParams);
        presetButton.setFocusable(true);
        presetButton.setContentDescription(this.mStringUtil.setString("string_add_preset"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(presetButton, presetAddPath, presetAddPressPath, presetAddFocusPath, 32, 32);
        return presetButton;
    }

    private View lineButton1() {
        float rightMargin = this.EXIT_BUTTON_RIGHT_MARGIN + this.EXIT_BUTTON_WIDTH + this.LINE_BUTTON_WIDTH + this.EXIT_BUTTON_WIDTH;
        ImageView lineView = new ImageView(this.mContext);
        RelativeLayout.LayoutParams presetButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(1.0f), this.mDrawableImg.getIntValueAppliedDensity(17.0f));
        presetButtonParams.addRule(11);
        presetButtonParams.addRule(15);
        presetButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(rightMargin);
        lineView.setLayoutParams(presetButtonParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(lineView, linePath);
        return lineView;
    }

    private View lineButton2() {
        float rightMargin = this.EXIT_BUTTON_RIGHT_MARGIN + this.EXIT_BUTTON_WIDTH;
        ImageView lineView = new ImageView(this.mContext);
        RelativeLayout.LayoutParams presetButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(1.0f), this.mDrawableImg.getIntValueAppliedDensity(17.0f));
        presetButtonParams.addRule(11);
        presetButtonParams.addRule(15);
        presetButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(rightMargin);
        lineView.setLayoutParams(presetButtonParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(lineView, linePath);
        return lineView;
    }

    private ViewGroup bodyBg() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setLayoutParams(bodyBgParam);
        ImageView bodyLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyLeftParam = new RelativeLayout.LayoutParams(-1, -1);
        bodyLeftParam.alignWithParent = true;
        bodyLeftParam.addRule(9);
        bodyLeftParam.addRule(10);
        bodyLeft.setLayoutParams(bodyLeftParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyLeft, lightBodyLeftPath);
        relativeLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        relativeLayout.setOnHoverListener(this.mOnConsumedHoverListener);
        relativeLayout.addView(bodyLeft);
        return relativeLayout;
    }

    private ViewGroup paletteBg() {
        RelativeLayout paletteBgLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, -1);
        paletteBgLayout.setLayoutParams(bodyBgParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(paletteBgLayout, grayBodyLeftPath);
        return paletteBgLayout;
    }

    private LinearLayout typeSelectorlayout() {
        LinearLayout typeButtonLayout = new LinearLayout(this.mContext);
        typeButtonLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(42.0f)));
        typeButtonLayout.setOrientation(0);
        typeButtonLayout.addView(penTypeButton());
        return typeButtonLayout;
    }

    private LinearLayout typeSelectorlayout2() {
        LinearLayout typeButtonLayout = new LinearLayout(this.mContext);
        typeButtonLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(42.0f)));
        typeButtonLayout.setOrientation(0);
        typeButtonLayout.addView(presetTypeButton());
        return typeButtonLayout;
    }

    private View penTypeButton() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams penBtnLayoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        linearLayout.setLayoutParams(penBtnLayoutParams);
        linearLayout.setOrientation(1);
        TextView mPenButton = new TextView(this.mContext);
        LinearLayout.LayoutParams fontButtonParams = new LinearLayout.LayoutParams(-1, -2);
        fontButtonParams.weight = 1.0f;
        mPenButton.setLayoutParams(fontButtonParams);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(mPenButton, tabLinePath, tabLineSelectPath, tabLineFocusPath);
        mPenButton.setSingleLine();
        mPenButton.setGravity(17);
        mPenButton.setText(this.mStringUtil.setString("string_pen"));
        mPenButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(19.0f));
        mPenButton.setTypeface(SpenFont.getTypeFace("Roboto-Regular"), 1);
        View bottomView = new View(this.mContext);
        LinearLayout.LayoutParams bottomViewParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(2.0f));
        bottomViewParam.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(11.0f);
        bottomViewParam.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(15.0f);
        bottomView.setLayoutParams(bottomViewParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(bottomView, "vienna_subtitle_line");
        linearLayout.setContentDescription(String.valueOf(this.mStringUtil.setString("string_pen_tab")) + this.mStringUtil.setString("string_selected"));
        int[] arrayOfStates1 = {-16842919, -16842913};
        int[] arrayOfStates2 = {R.attr.state_pressed};
        int[] arrayOfStates3 = {R.attr.state_selected};
        int[][] arrayOfStates = {arrayOfStates1, arrayOfStates2, arrayOfStates3};
        int[] textColor = {Color.rgb(0, 0, 0), Color.rgb(1, 139, ScreenSharePacket.SCREEN_SHARE_DOCS_CMD_PEN_MODE), Color.rgb(1, 139, ScreenSharePacket.SCREEN_SHARE_DOCS_CMD_PEN_MODE)};
        ColorStateList mTextColorStateList = new ColorStateList(arrayOfStates, textColor);
        mPenButton.setTextColor(mTextColorStateList);
        mPenButton.setClickable(true);
        mPenButton.setFocusable(true);
        mPenButton.setPadding(0, 0, 0, 0);
        mPenButton.setEnabled(false);
        linearLayout.addView(mPenButton);
        linearLayout.addView(bottomView);
        return linearLayout;
    }

    private View presetTypeButton() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams presetTypeButtonLayoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        linearLayout.setLayoutParams(presetTypeButtonLayoutParams);
        linearLayout.setOrientation(1);
        TextView mPresetButton = new TextView(this.mContext);
        LinearLayout.LayoutParams presetTypeButtonParams = new LinearLayout.LayoutParams(-1, -2);
        mPresetButton.setLayoutParams(presetTypeButtonParams);
        presetTypeButtonParams.weight = 1.0f;
        this.mImageLoader.addViewBackgroundSelectableImageLoad(mPresetButton, tabLinePath, tabLineSelectPath, tabLineSelectPath);
        mPresetButton.setSingleLine();
        mPresetButton.setGravity(17);
        mPresetButton.setText(this.mStringUtil.setString("string_preset"));
        mPresetButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(19.0f));
        mPresetButton.setTypeface(SpenFont.getTypeFace("Roboto-Regular"));
        View bottomView = new View(this.mContext);
        LinearLayout.LayoutParams bottomViewParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(2.0f));
        bottomViewParam.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(12.0f);
        bottomViewParam.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(15.0f);
        bottomView.setLayoutParams(bottomViewParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(bottomView, "vienna_subtitle_line");
        linearLayout.setContentDescription(String.valueOf(this.mStringUtil.setString("string_preset_tab")) + this.mStringUtil.setString("string_not_selected"));
        int[] arrayOfStates1 = {-16842919, -16842913};
        int[] arrayOfStates2 = {R.attr.state_pressed};
        int[] arrayOfStates3 = {R.attr.state_selected};
        int[][] arrayOfStates = {arrayOfStates1, arrayOfStates2, arrayOfStates3};
        int[] textColor = {Color.rgb(0, 0, 0), Color.rgb(28, 126, 196), Color.rgb(28, 126, 196)};
        ColorStateList mTextColorStateList = new ColorStateList(arrayOfStates, textColor);
        mPresetButton.setTextColor(mTextColorStateList);
        mPresetButton.setClickable(false);
        mPresetButton.setFocusable(true);
        mPresetButton.setPadding(0, 0, 0, 0);
        linearLayout.addView(mPresetButton);
        linearLayout.addView(bottomView);
        linearLayout.setEnabled(false);
        return linearLayout;
    }

    private ViewGroup penLayout() {
        this.mScrollView = new SpenScrollView(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(42.0f), this.mDrawableImg.getIntValueAppliedDensity(1.5f), 0);
        this.mScrollView.setLayoutParams(localLayoutParams);
        this.mScrollView.setVerticalFadingEdgeEnabled(false);
        this.mScrollView.setFadingEdgeLength(0);
        this.mScrollView.setVerticalScrollBarEnabled(true);
        this.mScrollView.setOverScrollMode(1);
        SpenPalletView palletViewLayout = new SpenPalletView(this.mContext);
        palletViewLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        palletViewLayout.setOrientation(1);
        this.mPenTypeLayout = penTypeLayout();
        this.mColorSelectPickerLayout = colorPaletteGradationLayout();
        this.mBeautifyEnableLayout = beautifyEnableLayout();
        this.mBeautifyStyleBtnsLayout = beautifyStyleBtnsLayout();
        this.mPenSeekbarLayout = penSeekbarLayout();
        this.mTypeSelectorLayout = typeSelectorlayout();
        LinearLayout bottonPaddingLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams bottonPaddingLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale));
        bottonPaddingLayout.setLayoutParams(bottonPaddingLayoutParams);
        bottonPaddingLayout.setBackgroundColor(0);
        palletViewLayout.addView(this.mPenTypeLayout);
        palletViewLayout.addView(this.mBeautifyEnableLayout);
        palletViewLayout.addView(this.mBeautifyStyleBtnsLayout);
        palletViewLayout.addView(this.mPenSeekbarLayout);
        palletViewLayout.addView(this.mColorSelectPickerLayout);
        palletViewLayout.addView(bottonPaddingLayout);
        this.mScrollView.addView(palletViewLayout);
        RelativeLayout penLayout = new RelativeLayout(this.mContext);
        penLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        penLayout.addView(this.mTypeSelectorLayout);
        penLayout.addView(this.mScrollView);
        return penLayout;
    }

    private LinearLayout presetLayout() {
        LinearLayout presetLayout = new LinearLayout(this.mContext);
        presetLayout.setPadding(this.mDrawableImg.getIntValueAppliedDensity(18.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f), this.mDrawableImg.getIntValueAppliedDensity(15.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
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
        this.mPresetGridView.setNumColumns(4);
        this.mPresetTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(283.0f), -1);
        textViewParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(8.0f), 0, 0, 0);
        this.mPresetTextView.setLayoutParams(textViewParams);
        this.mPresetTextView.setTypeface(Typeface.SANS_SERIF);
        this.mPresetTextView.setTextColor(Color.rgb(139, 139, 139));
        this.mPresetTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        this.mPresetTextView.setGravity(17);
        this.mPresetTextView.setText(this.mStringUtil.setString("string_no_preset"));
        this.mPresetTextView.setFocusable(false);
        this.mPresetTextView.setVisibility(8);
        this.mPresetTextView.setContentDescription(this.mStringUtil.setString("string_no_preset"));
        this.mPresetTextView.setPadding(0, this.mDrawableImg.getIntValueAppliedDensity(100.0f), 0, 0);
        presetLayout.addView(this.mPresetGridView);
        presetLayout.addView(this.mPresetTextView);
        return presetLayout;
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
        this.mBeautifyEnableTextView.setText(this.mBeautifyStr);
        this.mBeautifyEnableTextView.setFocusable(false);
        this.mBeautifyEnableTextView.setContentDescription(this.mBeautifyStr);
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

    private void showBeautifyEnableLayout(boolean show) {
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

    private void showBeautifyStyleBtnsLayout(boolean show) {
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
        localLinearLayout.setPadding(this.mDrawableImg.getIntValueAppliedDensity(12.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(12.0f), 0);
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
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(97.0f));
        previewLayout.setLayoutParams(localLayoutParams);
        previewLayout.setBackgroundColor(0);
        this.mPenPreview = new SpenPenPreview(this.mContext);
        this.mPenPreview.setPenPlugin(this.mPenPluginManager);
        RelativeLayout.LayoutParams penPreviewLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        penPreviewLayoutParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(-5.8f), this.mDrawableImg.getIntValueAppliedDensity(-1.0f), this.mDrawableImg.getIntValueAppliedDensity(-3.0f), 0);
        this.mPenPreview.setLayoutParams(penPreviewLayoutParams);
        this.mPenPreview.setBackgroundColor(0);
        this.mPenAlphaPreview = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams penPreviewLayoutParams02 = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(30.0f));
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
    public void penSelectIndex(int index) {
        for (int i = 0; i < this.mPenPluginCount; i++) {
            if (index == this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                this.mPenAlphaPreview.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(8);
                if (!this.previousPenMagicSelected) {
                    this.currentOrtherPenHeight = (int) this.mBottomLayout.getY();
                }
                setMagicPenMode(this.currenMagicPenHeight);
                this.previousPenMagicSelected = true;
                this.alphaDrawable.setAlpha(this.mPenAlpha);
            } else {
                this.mPenAlphaPreview.setVisibility(8);
                if (this.previousPenMagicSelected) {
                    this.currenMagicPenHeight = (int) this.mBottomLayout.getY();
                }
                this.isMagicPenEnable = false;
                this.alphaDrawable.setAlpha(255);
                this.mColorSelectPickerLayout.setVisibility(0);
                if (this.currentOrtherPenHeight == 99999) {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(428.0f));
                    this.currentOrtherPenHeight = (int) this.mBottomLayout.getY();
                } else if (this.previousPenMagicSelected) {
                    setExpandBarPosition(this.currentOrtherPenHeight);
                }
                this.previousPenMagicSelected = false;
            }
            if (index == i) {
                this.mPenTypeView.get(i).setSelected(true);
                this.mPenTypeView.get(i).performClick();
            } else {
                this.mPenTypeView.get(i).setSelected(false);
            }
        }
    }

    private ViewGroup penTypeLayout() {
        this.penTypeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(400.0f), this.mDrawableImg.getIntValueAppliedDensity(97.0f));
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
            this.mImageLoader.addViewBackgroundSelectableImageLoad(penButton, localUnselectImage, localSelectImage, localFocusImage, 89, 89);
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
                penButton.setContentDescription(this.mStringUtil.setString("string_magic_pen"));
            }
            if (isBeautifyPen(penPluginInfo.getPenName())) {
                penButton.setVisibility(8);
            }
            RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(89.0f), this.mDrawableImg.getIntValueAppliedDensity(89.0f));
            if (i > 0) {
                relativeParams.addRule(1, penButton.getId() - 1);
                relativeParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(-26.5f);
                this.penTypeLayout.addView(penButton, relativeParams);
            } else {
                relativeParams.addRule(9);
                relativeParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(6.0f);
                this.penTypeLayout.addView(penButton, relativeParams);
            }
            i++;
        }
        ImageButton penTouchView = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams penTouchViewParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(89.0f));
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
        this.mPenTypeHorizontalScrollView2.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(8.0f));
        this.mPenTypeHorizontalScrollView3 = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParamsNew = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), this.mDrawableImg.getIntValueAppliedDensity(97.0f));
        this.mPenTypeHorizontalScrollView3.setLayoutParams(layoutParamsNew);
        this.mPenTypeHorizontalScrollView3.setPadding(0, 0, this.mDrawableImg.getIntValueAppliedDensity(4.0f), 0);
        this.mPreviewLayout = preview();
        this.mPenTypeHorizontalScrollView3.addView(this.mPreviewLayout);
        this.mPenTypeHorizontalScrollView3.addView(this.mPenTypeHorizontalScrollView2);
        return this.mPenTypeHorizontalScrollView3;
    }

    private ViewGroup penSizeLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams sizeDisplayLayoutParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(62.0f));
        relativeLayout.setLayoutParams(sizeDisplayLayoutParam);
        relativeLayout.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        ImageView imgDivider = new ImageView(this.mContext);
        RelativeLayout.LayoutParams dividerParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        dividerParams.alignWithParent = true;
        dividerParams.addRule(6);
        dividerParams.addRule(14);
        dividerParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(0.5f);
        dividerParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        imgDivider.setLayoutParams(dividerParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(imgDivider, lineDivider);
        relativeLayout.addView(imgDivider);
        this.mPenSizePlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams plusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(36.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        plusImageParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        plusImageParam.alignWithParent = true;
        plusImageParam.addRule(11);
        plusImageParam.addRule(8);
        plusImageParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(2.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        this.mPenSizePlusButton.setLayoutParams(plusImageParam);
        this.mPenSizePlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mPenSizePlusButton, plusBgPath, plusBgPressPath, plusBgFocusPath, 36, 36);
        this.mPenSizeMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams minusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(36.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        minusImageParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        minusImageParam.alignWithParent = true;
        minusImageParam.addRule(9);
        minusImageParam.addRule(8);
        minusImageParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET), 0, this.mDrawableImg.getIntValueAppliedDensity(2.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        this.mPenSizeMinusButton.setLayoutParams(minusImageParam);
        this.mPenSizeMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mPenSizeMinusButton, minusBgPath, minusBgPressPath, minusBgFocusPath, 36, 36);
        this.mPenSizeSeekbar = penSizeSeekbar();
        this.mPenSizeTextView = new TextView(this.mContext);
        this.mPenSizeTextView.setTypeface(Typeface.SANS_SERIF, 1);
        this.mPenSizeTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mPenSizeTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        RelativeLayout.LayoutParams penAlphaTextParam = new RelativeLayout.LayoutParams(-2, this.mDrawableImg.getIntValueAppliedDensity(13.0f));
        penAlphaTextParam.addRule(4);
        this.mPenAlphaTextView.setLayoutParams(penAlphaTextParam);
        relativeLayout.addView(this.mPenSizeTextView);
        relativeLayout.addView(this.mPenSizeSeekbar);
        relativeLayout.addView(this.mPenSizePlusButton);
        relativeLayout.addView(this.mPenSizeMinusButton);
        return relativeLayout;
    }

    private SeekBar penSizeSeekbar() throws Resources.NotFoundException, IOException {
        final SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(229.0f), this.mDrawableImg.getIntValueAppliedDensity(33.0f));
        seekBarParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(2.0f), 0, 0, this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        seekBarParams.alignWithParent = true;
        seekBarParams.addRule(14);
        seekBarParams.addRule(8);
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(this.mDrawableImg.getIntValueAppliedDensity(15.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(15.0f), 0);
        seekBar.setMax(PEN_SIZE_MAX);
        seekBar.setThumb(this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 33, 33));
        this.mPenSizeSeekbarColor = new GradientDrawable();
        this.mPenSizeSeekbarColor.setColor(0);
        this.mPenSizeSeekbarColor.setCornerRadius(this.mDrawableImg.getIntValueAppliedDensity(7.0f));
        ClipDrawable localClipDrawable = new ClipDrawable(this.mPenSizeSeekbarColor, 3, 1);
        Drawable bgDrawable = this.mDrawableImg.setDrawableImg(progressBgPath, 229, 12);
        Drawable shadowDrawable = this.mDrawableImg.setDrawableImg(progressShadowPath, 229, 12);
        InsetDrawable bgInsetDrawable = new InsetDrawable(bgDrawable, 0, 0, 0, 0);
        InsetDrawable shadowInsetDrawable = new InsetDrawable(shadowDrawable, 0, 0, 0, 0);
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[]{bgInsetDrawable, shadowInsetDrawable, localClipDrawable});
        seekBar.setProgressDrawable(localLayerDrawable);
        seekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.52
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
                    default:
                        return false;
                }
            }
        });
        return seekBar;
    }

    private ViewGroup penAlphaLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams sizeDisplayLayoutParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(62.0f));
        relativeLayout.setLayoutParams(sizeDisplayLayoutParam);
        relativeLayout.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        ImageView imgDivider = new ImageView(this.mContext);
        RelativeLayout.LayoutParams dividerParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        dividerParams.alignWithParent = true;
        dividerParams.addRule(6);
        dividerParams.addRule(14);
        dividerParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(0.5f);
        dividerParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        imgDivider.setLayoutParams(dividerParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(imgDivider, lineDivider);
        relativeLayout.addView(imgDivider);
        this.mOpacityPlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams plusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(36.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        plusImageParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        plusImageParam.alignWithParent = true;
        plusImageParam.addRule(11);
        plusImageParam.addRule(8);
        plusImageParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(2.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        this.mOpacityPlusButton.setLayoutParams(plusImageParam);
        this.mOpacityPlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mOpacityPlusButton, plusBgPath, plusBgPressPath, plusBgFocusPath, 36, 36);
        this.mOpacityMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams minusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(36.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        minusImageParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        minusImageParam.alignWithParent = true;
        minusImageParam.addRule(9);
        minusImageParam.addRule(8);
        minusImageParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET), 0, this.mDrawableImg.getIntValueAppliedDensity(2.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        this.mOpacityMinusButton.setLayoutParams(minusImageParam);
        this.mOpacityMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mOpacityMinusButton, minusBgPath, minusBgPressPath, minusBgFocusPath, 36, 36);
        this.mPenAlphaSeekbar = penAlphaSeekbar();
        this.mPenAlphaTextView = new TextView(this.mContext);
        this.mPenAlphaTextView.setTypeface(Typeface.SANS_SERIF, 1);
        this.mPenAlphaTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mPenAlphaTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        RelativeLayout.LayoutParams penAlphaTextParam = new RelativeLayout.LayoutParams(-2, this.mDrawableImg.getIntValueAppliedDensity(13.0f));
        penAlphaTextParam.addRule(4);
        this.mPenAlphaTextView.setLayoutParams(penAlphaTextParam);
        relativeLayout.addView(this.mPenAlphaTextView);
        relativeLayout.addView(this.mPenAlphaSeekbar);
        relativeLayout.addView(this.mOpacityPlusButton);
        relativeLayout.addView(this.mOpacityMinusButton);
        return relativeLayout;
    }

    private SeekBar penAlphaSeekbar() throws Resources.NotFoundException, IOException {
        final SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(229.0f), this.mDrawableImg.getIntValueAppliedDensity(33.0f));
        seekBarParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(2.0f), 0, 0, this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        seekBarParams.alignWithParent = true;
        seekBarParams.addRule(14);
        seekBarParams.addRule(8);
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(this.mDrawableImg.getIntValueAppliedDensity(15.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(15.0f), 0);
        seekBar.setMax(PEN_SIZE_MAX);
        seekBar.setThumb(this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 33, 33));
        this.mPenAlphaSeekbarColor = new GradientDrawable();
        this.mPenAlphaSeekbarColor.setColor(0);
        this.mPenAlphaSeekbarColor.setCornerRadius(this.mDrawableImg.getIntValueAppliedDensity(7.0f));
        ClipDrawable localClipDrawable = new ClipDrawable(this.mPenAlphaSeekbarColor, 3, 1);
        Drawable localDrawable = this.mDrawableImg.setDrawableImg(progressShadowPath, 229, 12);
        this.alphaDrawable = this.mDrawableImg.setDrawableImg(progressAlphaPath, 229, 12);
        InsetDrawable localInsetDrawable = new InsetDrawable(localDrawable, 0, 0, 0, 0);
        InsetDrawable alphaInsetDrawable = new InsetDrawable(this.alphaDrawable, 0, 0, 0, 0);
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[]{localInsetDrawable, alphaInsetDrawable, localClipDrawable});
        seekBar.setProgressDrawable(localLayerDrawable);
        seekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.53
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
                    default:
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
        this.mBeautifyAdvanceCursiveSeekbar = beautifyAdvanceSeekBar();
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
        this.mBeautifyAdvanceSustenanceSeekbar = beautifyAdvanceSeekBar();
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
        this.mBeautifyAdvanceDummySeekbar = beautifyAdvanceSeekBar();
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
        this.mBeautifyAdvanceModulationSeekbar = beautifyAdvanceSeekBar();
        this.mBeautifyAdvanceModulationSeekbar.setMax(maxProgress);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceModulationMinusButton);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceModulationSeekbar);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceModulationPlusButton);
        linearLayout.addView(this.mBeautifyModulationTextView);
        linearLayout.addView(advanceSeekZoneLayout);
        return linearLayout;
    }

    private SeekBar beautifyAdvanceSeekBar() throws Resources.NotFoundException, IOException {
        SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(190.0f), -2);
        seekBarParams.alignWithParent = true;
        seekBarParams.addRule(14);
        seekBarParams.addRule(15);
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(this.mDrawableImg.getIntValueAppliedDensity(10.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(10.0f), 0);
        seekBar.setThumb(this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 22, 22));
        if (this.mBeautifySeekbarColor == null) {
            this.mBeautifySeekbarColor = new GradientDrawable();
            this.mBeautifySeekbarColor.setColor(0);
            this.mBeautifySeekbarColor.setCornerRadius(this.mDrawableImg.getIntValueAppliedDensity(4.5f));
        }
        ClipDrawable localClipDrawable = new ClipDrawable(this.mBeautifySeekbarColor, 3, 1);
        Drawable localDrawable = this.mDrawableImg.setDrawableImg(progressBgPath, 190, 9);
        InsetDrawable localInsetDrawable = new InsetDrawable(localDrawable, 0, 0, 0, 0);
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[]{localInsetDrawable, localClipDrawable});
        seekBar.setProgressDrawable(localLayerDrawable);
        return seekBar;
    }

    private Button beautifyAdvanceResetBtn() {
        this.mBeautifyAdvanceResetButton = new Button(this.mContext);
        LinearLayout.LayoutParams resetBtnLayoutParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(40.0f / mScale));
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
        if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getPenAttribute(4)) {
            this.mSettingInfo.advancedSetting = this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getAdvancedSetting();
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
    }

    private ViewGroup PickerView() {
        RelativeLayout localLinearLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(261.0f), this.mDrawableImg.getIntValueAppliedDensity(65.0f));
        localLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(34.0f);
        localLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(34.0f);
        localLayoutParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(88.0f);
        localLinearLayout.setLayoutParams(localLayoutParams);
        this.mColorGradationView = colorGradationView();
        localLinearLayout.addView(this.mColorGradationView);
        return localLinearLayout;
    }

    private ViewGroup colorPaletteGradationLayout() {
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

    private ViewGroup PaletteView() {
        RelativeLayout sizeDisplayLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams sizeDisplayLayoutParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(83.0f));
        sizeDisplayLayoutParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(4.0f), this.mDrawableImg.getIntValueAppliedDensity(3.0f), this.mDrawableImg.getIntValueAppliedDensity(4.0f), 0);
        sizeDisplayLayout.setLayoutParams(sizeDisplayLayoutParam);
        this.mPaletteRightButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams rightImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(27.0f), this.mDrawableImg.getIntValueAppliedDensity(83.0f));
        rightImageParam.alignWithParent = true;
        rightImageParam.addRule(11);
        rightImageParam.addRule(15);
        this.mPaletteRightButton.setLayoutParams(rightImageParam);
        this.mPaletteRightButton.setContentDescription(this.mStringUtil.setString("string_next"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mPaletteRightButton, rightBgPath, rightBgPresslPath, rightBgFocuslPath, 27, 83);
        this.mPaletteLeftButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams leftImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(27.0f), this.mDrawableImg.getIntValueAppliedDensity(83.0f));
        leftImageParam.alignWithParent = true;
        leftImageParam.addRule(9);
        leftImageParam.addRule(15);
        this.mPaletteLeftButton.setLayoutParams(leftImageParam);
        this.mPaletteLeftButton.setContentDescription(this.mStringUtil.setString("string_back"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mPaletteLeftButton, leftBgPath, lefBgPresslPath, lefBgFocuslPath, 27, 83);
        this.mColorPaletteView = colorPaletteView();
        sizeDisplayLayout.addView(this.mPaletteLeftButton);
        sizeDisplayLayout.addView(this.mColorPaletteView);
        sizeDisplayLayout.addView(this.mPaletteRightButton);
        return sizeDisplayLayout;
    }

    private SpenColorPaletteView2 colorPaletteView() {
        this.colorPaletteView = new SpenColorPaletteView2(this.mContext, this.mDrawableImg.mCustom_imagepath, mScale);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(261.0f), -2);
        localLayoutParams.alignWithParent = true;
        localLayoutParams.addRule(14);
        localLayoutParams.addRule(15);
        this.colorPaletteView.setLayoutParams(localLayoutParams);
        this.colorPaletteView.setClickable(true);
        this.colorPaletteView.setFocusable(true);
        return this.colorPaletteView;
    }

    private SpenColorGradationView2 colorGradationView() {
        SpenColorGradationView2 localf = new SpenColorGradationView2(this.mContext, this.mDrawableImg.mCustom_imagepath, mScale);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(261.0f), this.mDrawableImg.getIntValueAppliedDensity(65.0f));
        localf.setLayoutParams(localLayoutParams);
        localf.setClickable(true);
        localf.setContentDescription(this.mStringUtil.setString("string_gradation"));
        localf.setPadding(0, 0, 0, 0);
        return localf;
    }

    private View bottomLayout() {
        RelativeLayout bottomLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale));
        bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(366.0f - (1.0f / mScale)), 0, 0);
        bottomLayout.setLayoutParams(bottomLayoutParams);
        this.mBottomExtendBg = new ImageView(this.mContext);
        this.mBottomExtendBg.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale)));
        this.mImageLoader.addViewSetBackgroundImageLoad(this.mBottomExtendBg, bottomExpandPath);
        this.mBottomHandle = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bottomHandleParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(22.0f / mScale), this.mDrawableImg.getIntValueAppliedDensity(16.0f / mScale));
        bottomHandleParam.alignWithParent = true;
        bottomHandleParam.addRule(14);
        bottomHandleParam.addRule(8);
        this.mBottomHandle.setLayoutParams(bottomHandleParam);
        this.mBottomHandle.setImageDrawable(this.mDrawableImg.setDrawableImg(bottomHandlePath, (int) (22.0f / mScale), (int) (16.0f / mScale)));
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
            if ((isBeautifyPen(this.mSettingInfo.name) || isChinesePen(this.mSettingInfo.name)) && this.mSupportBeautifyPen && hasBeautifyPen()) {
                boolean isBeautify = isBeautifyPen(this.mSettingInfo.name);
                if (this.mBeautifyEnableSwitchView.isChecked() != isBeautify) {
                    this.mBeautifyEnableSwitchView.setChecked(isBeautify);
                }
                showBeautifyEnableLayout(true);
                if (this.mBeautifyStyleBtnsLayout.getVisibility() != 0) {
                    if (isBeautify) {
                        showBeautifyStyleBtnsLayout(true);
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
                    if (this.mBodyLayoutHeight - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale) >= this.mDrawableImg.getIntValueAppliedDensity(366.0f) || this.mBodyLayoutHeight == -2 || this.mBodyLayoutHeight == 0) {
                        int bodyHeight = this.mDrawableImg.getIntValueAppliedDensity(504.0f);
                        int bottomTopMargin = bodyHeight - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale);
                        if (this.mCanvasLayout.getHeight() > 0 && this.mCanvasLayout.getHeight() < bodyHeight) {
                            bodyHeight = this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(41.0f);
                            bottomTopMargin = bodyHeight - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale);
                        }
                        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, bodyHeight);
                        this.mBodyLayout.setLayoutParams(localLayoutParams);
                        RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, bodyHeight - this.mDrawableImg.getIntValueAppliedDensity(130.0f));
                        this.mBodyBg.setLayoutParams(bodyBgParam);
                        RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale));
                        bottomLayoutParams.setMargins(0, bottomTopMargin, 0, 0);
                        this.mBottomLayout.setLayoutParams(bottomLayoutParams);
                        this.mBodyLayoutHeight = bodyHeight;
                        setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(504.0f));
                        return;
                    }
                    LinearLayout.LayoutParams bodyParam = new LinearLayout.LayoutParams(-1, this.mBodyLayoutHeight);
                    this.mBodyLayout.setLayoutParams(bodyParam);
                    RelativeLayout.LayoutParams bottomLayoutParams2 = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale));
                    bottomLayoutParams2.setMargins(0, this.mBodyLayoutHeight - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale), 0, 0);
                    this.mBottomLayout.setLayoutParams(bottomLayoutParams2);
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(504.0f));
                    return;
                }
                if (this.mBodyLayoutHeight - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale) >= this.mDrawableImg.getIntValueAppliedDensity(366.0f) || this.mBodyLayoutHeight == -2 || this.mBodyLayoutHeight == 0) {
                    int bodyHeight2 = this.mDrawableImg.getIntValueAppliedDensity(428.0f + (1.0f / mScale));
                    int bottomTopMargin2 = bodyHeight2 - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale);
                    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    this.mBodyLayout.setLayoutParams(localLayoutParams2);
                    if (this.mCanvasLayout.getHeight() > 0 && this.mCanvasLayout.getHeight() < bodyHeight2) {
                        bodyHeight2 = this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(41.0f);
                        bottomTopMargin2 = bodyHeight2 - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale);
                    }
                    RelativeLayout.LayoutParams bodyBgParam2 = new RelativeLayout.LayoutParams(-1, bodyHeight2);
                    this.mBodyBg.setLayoutParams(bodyBgParam2);
                    RelativeLayout.LayoutParams bottomLayoutParams3 = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale));
                    bottomLayoutParams3.setMargins(0, bottomTopMargin2, 0, 0);
                    this.mBottomLayout.setLayoutParams(bottomLayoutParams3);
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(428.0f));
                    return;
                }
                return;
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
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(428.0f));
                    return;
                }
                if (this.mBodyLayoutHeight >= this.mDrawableImg.getIntValueAppliedDensity(366.0f)) {
                    if (this.mWindowHeight > this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(41.0f + (1.0f / mScale) + 62.0f)) {
                        setExpandBarPosition(this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(62.0f));
                        return;
                    } else {
                        if (this.mViewMode == 8) {
                            setExpandBarPosition(1000);
                            return;
                        }
                        return;
                    }
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
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(366.0f));
            } else {
                setExpandBarPosition(this.mBodyLayoutHeight);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void presetDisplay() {
        if (this.mPresetGridView != null) {
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

    public void setViewMode(int viewMode) throws NumberFormatException {
        this.mViewMode = viewMode;
        if (this.mColorPickerSetting.mSpuitSettings.isShown()) {
            this.mColorPickerSetting.hide();
            if (this.mCanvasView != null) {
                this.mCanvasView.setToolTypeAction(2, this.mPreCanvasPenAction);
                this.mCanvasView.setToolTypeAction(1, this.mPreCanvasFingerAction);
            }
        }
        if (this.mViewMode == 1) {
            this.deltaOfMiniMode = 52;
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(113.0f));
            this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams);
            this.isMinimumMode = true;
        } else {
            this.deltaOfMiniMode = 0;
            this.mColorGradationView.setVisibility(0);
            this.isMinimumMode = false;
        }
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(163.0f - this.deltaOfMiniMode));
        this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams2);
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
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
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
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight);
                    break;
                }
                break;
            case 3:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mColorGradationView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mPresetAddButton.setVisibility(8);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight);
                    break;
                }
                break;
            case 4:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(8);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(8);
                this.mColorSelectPickerLayout.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(75.0f));
                break;
            case 5:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(8);
                this.mPreviewLayout.setVisibility(8);
                this.mPenTypeLayout.setVisibility(8);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(92.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(46.0f));
                    break;
                }
            case 6:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(8);
                this.mPreviewLayout.setVisibility(8);
                this.mPenTypeLayout.setVisibility(8);
                this.mPenSeekbarLayout.setVisibility(8);
                this.mColorGradationView.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(114.0f));
                break;
            case 7:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(8);
                this.mPreviewLayout.setVisibility(8);
                this.mPenTypeLayout.setVisibility(8);
                this.mPenSeekbarLayout.setVisibility(8);
                this.mColorSelectPickerLayout.setVisibility(8);
                this.mColorPaletteView.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight);
                    break;
                }
                break;
            case 8:
                break;
            case 9:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mColorGradationView.setVisibility(0);
                this.mBottomLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(8);
                this.mLine1Button.setVisibility(8);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight);
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
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight);
                    break;
                }
                break;
        }
        this.mCount = 0;
        int realIndex = 0;
        while (realIndex < this.mPenTypeView.size() && !this.mPenTypeView.get(realIndex).isSelected()) {
            realIndex++;
        }
        if (!isHighlightPenRemoved && !isMagicPenRemoved && this.mPenTypeHorizontalScrollView2 != null) {
            if (realIndex < 5) {
                this.mPenTypeHorizontalScrollView2.setVisibility(4);
                this.mPenTypeHorizontalScrollView2.scrollTo(this.mDrawableImg.getIntValueAppliedDensity(SUITABLE_WIDTH_IN_ANIMATION_SCROLL), 0);
                this.mPenTypeHorizontalScrollView2.setVisibility(0);
                playScrollAnimation(10, this.mDrawableImg.getIntValueAppliedDensity(SUITABLE_WIDTH_IN_ANIMATION_SCROLL), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            } else if (realIndex == 5) {
                playScrollAnimation(10, this.mPenTypeHorizontalScrollView2.getScrollX(), this.mDrawableImg.getIntValueAppliedDensity(SUITABLE_WIDTH_IN_ANIMATION_SCROLL));
            }
        }
        this.mPenAlphaPreview.setAlpha((float) (this.mPenAlphaSeekbar.getProgress() / 100.0d));
        if (this.mPenAlphaSeekbar.getProgress() == 0) {
            this.mPenAlphaTextView.setText("1%");
            this.mPenAlphaTextView.setX(this.mDrawableImg.getIntValueAppliedDensity(45.0f));
            this.mPenAlphaTextView.setY(this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        }
        if (this.isMagicPenEnable) {
            setMagicPenMode(this.currenMagicPenHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void penSelection(android.view.View r13) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.penSelection(android.view.View):void");
    }

    private void setMagicPenMode(int height) {
        this.isMagicPenEnable = true;
        this.mColorSelectPickerLayout.setVisibility(8);
        this.mPenAlphaSeekbarView.setVisibility(0);
        this.mPenSizeSeekbarColor.setColor(0);
        this.mPenAlphaSeekbarColor.setColor(0);
        if (height == 99999) {
            setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(267.0f));
        } else {
            setExpandBarPosition(height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpandBarPosition(int position) {
        RelativeLayout.LayoutParams PaletteBgParam;
        if (this.isMagicPenEnable && !this.isPresetClicked && position > this.mDrawableImg.getIntValueAppliedDensity(267.0f)) {
            position = this.mDrawableImg.getIntValueAppliedDensity(267.0f);
            RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, -2);
            this.mBodyBg.setLayoutParams(bodyBgParam);
            RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(428.0f), 0, 0);
            this.mBottomLayout.setLayoutParams(bottomLayoutParams);
        }
        if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
            if (position < 0) {
                position = this.mDrawableImg.getIntValueAppliedDensity(428 - this.deltaOfMiniMode);
            }
            if (position > this.mDrawableImg.getIntValueAppliedDensity(428 - this.deltaOfMiniMode)) {
                position = this.mDrawableImg.getIntValueAppliedDensity(428 - this.deltaOfMiniMode);
                RelativeLayout.LayoutParams bodyBgParam2 = new RelativeLayout.LayoutParams(-1, -2);
                this.mBodyBg.setLayoutParams(bodyBgParam2);
                RelativeLayout.LayoutParams bottomLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                bottomLayoutParams2.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(428 - this.deltaOfMiniMode), 0, 0);
                this.mBottomLayout.setLayoutParams(bottomLayoutParams2);
            }
        } else if (this.mSupportBeautifyPen && hasBeautifyPen() && (isBeautifyPen(this.mSettingInfo.name) || isChinesePen(this.mSettingInfo.name))) {
            if (isBeautifyPen(this.mSettingInfo.name)) {
                int bodyHeight = this.mDrawableImg.getIntValueAppliedDensity(504.0f);
                int bottomTopMargin = bodyHeight - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale);
                if (this.mCanvasLayout.getHeight() > 0 && this.mCanvasLayout.getHeight() < bodyHeight) {
                    bodyHeight = this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(41.0f);
                    bottomTopMargin = bodyHeight - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale);
                }
                if (position > bottomTopMargin) {
                    position = bottomTopMargin;
                    RelativeLayout.LayoutParams bottomLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                    bottomLayoutParams3.setMargins(0, bottomTopMargin, 0, 0);
                    this.mBottomLayout.setLayoutParams(bottomLayoutParams3);
                    RelativeLayout.LayoutParams bodyBgParam3 = new RelativeLayout.LayoutParams(-1, bodyHeight);
                    this.mBodyBg.setLayoutParams(bodyBgParam3);
                }
            } else if (position > this.mDrawableImg.getIntValueAppliedDensity(417.0f + (1.0f / mScale)) - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale)) {
                int bottomTopMargin2 = this.mDrawableImg.getIntValueAppliedDensity(417.0f + (1.0f / mScale)) - this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale);
                position = bottomTopMargin2;
                RelativeLayout.LayoutParams bottomLayoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
                bottomLayoutParams4.setMargins(0, bottomTopMargin2, 0, 0);
                this.mBottomLayout.setLayoutParams(bottomLayoutParams4);
                RelativeLayout.LayoutParams bodyBgParam4 = new RelativeLayout.LayoutParams(-1, -2);
                this.mBodyBg.setLayoutParams(bodyBgParam4);
            }
        } else {
            if (position < 0) {
                position = this.mDrawableImg.getIntValueAppliedDensity(366 - this.deltaOfMiniMode);
            }
            if (position > this.mDrawableImg.getIntValueAppliedDensity(366 - this.deltaOfMiniMode)) {
                position = this.mDrawableImg.getIntValueAppliedDensity(366 - this.deltaOfMiniMode);
                RelativeLayout.LayoutParams bodyBgParam5 = new RelativeLayout.LayoutParams(-1, -2);
                this.mBodyBg.setLayoutParams(bodyBgParam5);
                RelativeLayout.LayoutParams bottomLayoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
                bottomLayoutParams5.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(365.0f), 0, 0);
                this.mBottomLayout.setLayoutParams(bottomLayoutParams5);
            }
        }
        Display nowDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point p = new Point();
        nowDisplay.getSize(p);
        int windowHeight = p.y;
        int windowWidth = p.x;
        int actualHeight = this.mCanvasLayout.getHeight() > windowHeight ? windowHeight : this.mCanvasLayout.getHeight();
        int actualWidth = this.mCanvasLayout.getWidth() > windowWidth ? windowWidth : this.mCanvasLayout.getWidth();
        if (actualHeight > 0 && position > actualHeight) {
            position = actualHeight - this.mDrawableImg.getIntValueAppliedDensity((1.0f / mScale) + 41.0f);
        }
        if (this.mOrientation == 1) {
            if (actualHeight > 0 && this.mDrawableImg.getIntValueAppliedDensity(41.0f + (1.0f / mScale)) + position > actualHeight) {
                position = actualHeight - this.mDrawableImg.getIntValueAppliedDensity(41.0f + (1.0f / mScale));
            }
        } else if (actualWidth > 0 && this.mDrawableImg.getIntValueAppliedDensity(41.0f + (1.0f / mScale)) + position > actualWidth) {
            position = actualWidth - this.mDrawableImg.getIntValueAppliedDensity(41.0f + (1.0f / mScale));
        }
        if (position < this.mDrawableImg.getIntValueAppliedDensity(105.0f)) {
            position = this.mDrawableImg.getIntValueAppliedDensity(105.0f);
        }
        this.mBodyLayoutHeight = position;
        LinearLayout.LayoutParams bodyParam = new LinearLayout.LayoutParams(-1, this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale));
        this.mBodyLayout.setLayoutParams(bodyParam);
        RelativeLayout.LayoutParams bodyBgParam6 = new RelativeLayout.LayoutParams(-1, this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(1.0f / mScale));
        this.mBodyBg.setLayoutParams(bodyBgParam6);
        if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
            PaletteBgParam = new RelativeLayout.LayoutParams(-1, (this.mDrawableImg.getIntValueAppliedDensity(163.0f) - (this.mDrawableImg.getIntValueAppliedDensity(428.0f) - this.mBodyLayoutHeight)) + this.mScrollY);
        } else {
            PaletteBgParam = new RelativeLayout.LayoutParams(-1, (this.mDrawableImg.getIntValueAppliedDensity(163.0f) - (this.mDrawableImg.getIntValueAppliedDensity(366.0f) - this.mBodyLayoutHeight)) + this.mScrollY);
        }
        PaletteBgParam.setMargins(0, 0, this.mDrawableImg.getIntValueAppliedDensity(-1.5f), 0);
        if (PaletteBgParam.height >= 0) {
            this.mPaletteBg.setLayoutParams(PaletteBgParam);
        }
        RelativeLayout.LayoutParams bottomLayoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        bottomLayoutParams6.setMargins(0, this.mBodyLayoutHeight, 0, 0);
        this.mBottomLayout.setLayoutParams(bottomLayoutParams6);
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
            canvasView.setBackgroundColorChangeListener(this, new SpenSettingViewInterface.SpenBackgroundColorChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.54
                @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface.SpenBackgroundColorChangeListener
                public void onChanged(boolean transparent) {
                    if (!transparent) {
                        SpenSettingPenLayout2.this.removePen(5);
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

    public void setInfo(SpenSettingPenInfo settingInfo) throws NumberFormatException {
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
            if ((this.mCanvasSize * max) / 360.0d < this.mSettingInfo.size) {
                this.mSettingInfo.size = (float) ((this.mCanvasSize * max) / 360.0d);
            }
            if ((this.mCanvasSize * min) / 360.0d > this.mSettingInfo.size) {
                this.mSettingInfo.size = (float) ((this.mCanvasSize * min) / 360.0d);
            }
            this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().setSize(this.mSettingInfo.size);
            this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().setColor(this.mSettingInfo.color);
            if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getPenAttribute(1)) {
                this.mPenAlpha = (settingInfo.color >> 24) & 255;
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
            float tempSize = this.mSettingInfo.size;
            this.mPenSizeSeekbar.setMax(Math.round((max - min) * 10.0f));
            this.mSettingInfo.size = tempSize;
            int progress = Math.round((((this.mSettingInfo.size * 360.0f) / this.mCanvasSize) - min) * 10.0f);
            this.mPenSizeSeekbar.setProgress(progress);
            this.mPenSizeSeekbarColor.setColor((this.mSettingInfo.color & 16777215) | (-16777216));
            this.mPenSizeSeekbarColor.setAlpha(255);
            this.mPenAlphaSeekbar.setProgress(Math.round((this.mPenAlpha / 255.0f) * 99.0f));
            this.mPenAlphaSeekbarColor.setColor(this.mSettingInfo.color);
            this.mColorPaletteView.setColor(settingInfo.color);
            this.mBeautifySeekbarColor.setColor(this.mSettingInfo.color);
            this.mBeautifyAdvanceCursiveSeekbar.invalidate();
            this.mBeautifyAdvanceDummySeekbar.invalidate();
            this.mBeautifyAdvanceSustenanceSeekbar.invalidate();
            this.mBeautifyAdvanceModulationSeekbar.invalidate();
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

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 0 && !this.mImageLoader.mLoaded) {
            this.mImageLoader.loadImage();
        }
        if (this.mColorPickerSetting != null && this.mColorPickerSetting.mSpuitSettings != null) {
            if (this.mColorPickerSetting.mSpuitSettings.isShown()) {
                this.mColorPickerSetting.hide();
                if (this.mCanvasView != null) {
                    this.mCanvasView.setToolTypeAction(2, this.mPreCanvasPenAction);
                    this.mCanvasView.setToolTypeAction(1, this.mPreCanvasFingerAction);
                }
            }
            this.isPresetClicked = false;
            super.setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playScrollAnimationChoosePen() {
        int bodyLayoutHeight;
        if (this.mPenAlphaSeekbarView.getVisibility() != 0) {
            bodyLayoutHeight = 366;
        } else if (this.isMagicPenEnable) {
            bodyLayoutHeight = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_RIGHT_ALIGN_EVENT;
            this.mPenSizeSeekbarColor.setColor(0);
            this.mPenAlphaSeekbarColor.setColor(0);
        } else {
            bodyLayoutHeight = 428;
        }
        playScrollAnimationForBottomBar(4, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(bodyLayoutHeight + 41 + 200));
        setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(bodyLayoutHeight));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playScrollAnimation(int delay, final float from, final float to) {
        if (this.mScrollTimerForScrollPen != null) {
            this.mScrollTimerForScrollPen.cancel();
        }
        final float step = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        this.mScrollTimerForScrollPen = new Timer();
        this.mCountForScrollPen = 0;
        this.mScrollTimerForScrollPen.scheduleAtFixedRate(new TimerTask() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.55
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Handler handler = SpenSettingPenLayout2.this.mHandlerForScrollPen;
                final float f = from;
                final float f2 = to;
                final float f3 = step;
                handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.55.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenSettingPenLayout2.this.mCountForScrollPen++;
                        if (f > f2) {
                            float pos = f - (SpenSettingPenLayout2.this.mCountForScrollPen * f3);
                            if (pos > f2) {
                                SpenSettingPenLayout2.this.mPenTypeHorizontalScrollView2.scrollTo((int) pos, 0);
                                return;
                            }
                            SpenSettingPenLayout2.this.mPenTypeHorizontalScrollView2.scrollTo((int) f2, 0);
                            if (SpenSettingPenLayout2.this.mScrollTimerForScrollPen != null) {
                                SpenSettingPenLayout2.this.mScrollTimerForScrollPen.cancel();
                                SpenSettingPenLayout2.this.mScrollTimerForScrollPen = null;
                                return;
                            }
                            return;
                        }
                        float pos2 = f + (SpenSettingPenLayout2.this.mCountForScrollPen * f3);
                        if (pos2 < f2) {
                            SpenSettingPenLayout2.this.mPenTypeHorizontalScrollView2.scrollTo((int) pos2, 0);
                            return;
                        }
                        SpenSettingPenLayout2.this.mPenTypeHorizontalScrollView2.scrollTo((int) f2, 0);
                        if (SpenSettingPenLayout2.this.mScrollTimerForScrollPen != null) {
                            SpenSettingPenLayout2.this.mScrollTimerForScrollPen.cancel();
                            SpenSettingPenLayout2.this.mScrollTimerForScrollPen = null;
                        }
                    }
                });
            }
        }, 10L, delay);
    }

    private void playScrollAnimationForBottomBar(int delay, final int from, final int to) {
        if (this.mScrollTimer != null) {
            this.mScrollTimer.cancel();
            this.mScrollTimer = null;
        }
        this.mScrollTimer = new Timer();
        this.mCount = 0;
        this.mScrollTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.56
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Handler handler = SpenSettingPenLayout2.this.mHandler;
                final int i = from;
                final int i2 = to;
                handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.56.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenSettingPenLayout2.this.mCount += 5;
                        if (i > i2) {
                            int pos = i - SpenSettingPenLayout2.this.mCount;
                            SpenSettingPenLayout2.this.setLayoutHeight(pos);
                            if (pos <= i2) {
                                SpenSettingPenLayout2.this.setLayoutHeight(i2);
                                if (SpenSettingPenLayout2.this.mScrollTimer != null) {
                                    SpenSettingPenLayout2.this.mScrollTimer.cancel();
                                    SpenSettingPenLayout2.this.mScrollTimer = null;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int pos2 = i + SpenSettingPenLayout2.this.mCount;
                        SpenSettingPenLayout2.this.setLayoutHeight(pos2);
                        if (pos2 >= i2) {
                            SpenSettingPenLayout2.this.setLayoutHeight(i2);
                            if (SpenSettingPenLayout2.this.mScrollTimer != null) {
                                SpenSettingPenLayout2.this.mScrollTimer.cancel();
                                SpenSettingPenLayout2.this.mScrollTimer = null;
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

    protected void onScroll(MotionEvent motionEvent) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        try {
            this.mWindowHeight = h;
            if (!this.mExpandFlag) {
                this.mDrawableImg.getIntValueAppliedDensity((1.0f / mScale) + 41.0f);
            }
            int minWidth = this.mDrawableImg.getIntValueAppliedDensity(250.0f);
            int minHeight = this.mDrawableImg.getIntValueAppliedDensity(163.0f);
            if (w < minWidth || h < minHeight) {
                this.mMovableRect.set(getMovableRect());
                checkPosition();
            }
            Handler handler = new Handler();
            handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.57
                @Override // java.lang.Runnable
                public void run() {
                    SpenSettingPenLayout2.this.requestLayout();
                }
            });
            super.onSizeChanged(w, h, oldw, oldh);
        } catch (NullPointerException e) {
        }
    }
}
