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
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
class SpenSettingRemoverLayout2 extends LinearLayout {
    protected static final int BODY_LAYOUT_HEIGHT = 194;
    protected static final int ERASER_PROGRESS_MAX = 9;
    protected static final int ERASER_SIZE_MAX = 10;
    protected static final int EXIT_BUTTON_RAW_HEIGHT = 36;
    protected static final int EXIT_BUTTON_RAW_WIDTH = 38;
    protected static final int LINE_BUTTON_RAW_HEIGHT = 17;
    protected static final int LINE_BUTTON_RAW_WIDTH = 1;
    private static final int REP_DELAY = 20;
    private static final String TAG = "settingui-settingEraser";
    protected static final int TITLE_LAYOUT_HEIGHT = 42;
    public static final int VIEW_MODE_NORMAL = 0;
    public static final int VIEW_MODE_SIZE = 2;
    public static final int VIEW_MODE_TITLE = 3;
    public static final int VIEW_MODE_TYPE = 1;
    private static final String bodyLeftPath = "vienna_popup_bg";
    private static final String btnFocusPath = "snote_popup_btn_focus";
    private static final String btnNoramlPath = "snote_popup_btn_normal";
    private static final String btnPressPath = "snote_popup_btn_press";
    private static final String eraserPopupDrawPress = "snote_eraser_popup_draw_press";
    private static final String eraserPopupDrawUnselect = "snote_eraser_popup_draw";
    private static final String eraserPopupTextPress = "snote_eraser_popup_text_press";
    private static final String eraserPopupTextUnselect = "snote_eraser_popup_text";
    private static final String handelFocusPath = "progress_handle_focus";
    private static final String handelPath = "progress_handle_normal";
    private static final String handelPressPath = "progress_handle_press";
    private static final int mSdkVersion = Build.VERSION.SDK_INT;
    private static final String minusBgDimPath = "snote_popup_progress_btn_minus_dim";
    private static final String minusBgFocusPath = "snote_popup_progress_btn_minus_focus";
    private static final String minusBgPath = "snote_popup_progress_btn_minus_normal";
    private static final String minusBgPressPath = "snote_popup_progress_btn_minus_press";
    private static final String plusBgDimPath = "snote_popup_progress_btn_plus_dim";
    private static final String plusBgFocusPath = "snote_popup_progress_btn_plus_focus";
    private static final String plusBgPath = "snote_popup_progress_btn_plus_normal";
    private static final String plusBgPressPath = "snote_popup_progress_btn_plus_press";
    private static final String popupMaxPath = "snote_popup_arrow_max_normal";
    private static final String popupMinPath = "snote_popup_arrow_min_normal";
    private static final String progressBgPath = "progress_bg";
    private static final String progressShadowPath = "progress_shadow";
    private static final String titleLeftPath = "vienna_popup_title_bg";
    protected int EXIT_BUTTON_HEIGHT;
    protected float EXIT_BUTTON_RIGHT_MARGIN;
    protected float EXIT_BUTTON_TOP_MARGIN;
    protected int EXIT_BUTTON_WIDTH;
    protected float LINE_BUTTON_TOP_MARGIN;
    protected ActionListener mActionListener;
    private boolean mAutoDecrement;
    private boolean mAutoIncrement;
    protected View mBodyLayout;
    protected RelativeLayout mCanvasLayout;
    protected int mCanvasSize;
    protected SpenSettingViewInterface mCanvasView;
    private final CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    protected View mClearAllButton;
    private final View.OnClickListener mClearAllListener;
    protected Context mContext;
    private int mCount;
    protected int mCurrentCutterType;
    protected int mCurrentEraserType;
    protected SpenSettingRemoverInfo[] mCutterDataList;
    private View mCutterTypeChekBox;
    protected SPenImageUtil mDrawableImg;
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
    protected boolean mFirstLongPress;
    private final Handler mHandler;
    private SpenImageLoader mImageLoader;
    protected int mLeftMargin;
    private final View.OnLongClickListener mLongClickMinusButtonListener;
    private final View.OnLongClickListener mLongClickPlusButtonListener;
    private final View.OnClickListener mMinusButtonListener;
    protected Rect mMovableRect;
    protected boolean mMoveErasersettingLayout;
    private final View.OnTouchListener mOnConsumedTouchListener;
    private final View.OnClickListener mPlusButtonListener;
    private final View.OnClickListener mPopupButtonListener;
    private PopupListener mPopupListener;
    protected View mPopupMaxButton;
    protected View mPopupMinButton;
    protected float mScale;
    private Timer mScrollTimer;
    protected SpenSettingRemoverInfo mSettingInfo;
    protected ViewGroup mSettingSizeLayout;
    protected SPenTextUtil mStringUtil;
    protected View mTitleLayout;
    protected int mTopMargin;
    protected int mTotalLeftMargin;
    protected int mTotalTopMargin;
    private final View.OnTouchListener mTouchMinusButtonListener;
    private final View.OnTouchListener mTouchPlusButtonListener;
    protected int mViewMode;
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

    public interface PopupListener {
        void onPopup(boolean z);
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
        if (!this.mFirstLongPress) {
            this.mMovableRect.set(getMovableRect());
            if (getVisibility() != 8) {
                rotatePosition();
            }
        }
        super.onConfigurationChanged(newConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnableSizeSeekbar(boolean enabled) {
        if (enabled) {
            this.mEraserSizeSeekBar.setEnabled(true);
            this.mEraserPlusButton.setEnabled(true);
            this.mEraserMinusButton.setEnabled(true);
            this.mEraserSizeTextView.setVisibility(0);
            ((CompoundButton) this.mCutterTypeChekBox).setChecked(false);
            if (this.mSettingInfo.type != 1) {
                if (this.mEraserSizeSeekBar.getProgress() == this.mEraserSizeSeekBar.getMax()) {
                    this.mEraserPlusButton.setSelected(false);
                    this.mEraserPlusButton.setEnabled(false);
                    if (this.mAutoIncrement) {
                        this.mAutoIncrement = false;
                    }
                } else {
                    this.mEraserPlusButton.setEnabled(true);
                }
                if (this.mEraserSizeSeekBar.getProgress() == 0) {
                    this.mEraserMinusButton.setSelected(false);
                    this.mEraserMinusButton.setEnabled(false);
                    if (this.mAutoDecrement) {
                        this.mAutoDecrement = false;
                        return;
                    }
                    return;
                }
                this.mEraserMinusButton.setEnabled(true);
                return;
            }
            return;
        }
        this.mEraserSizeSeekBar.setEnabled(false);
        this.mEraserPlusButton.setEnabled(false);
        this.mEraserMinusButton.setEnabled(false);
        this.mEraserSizeTextView.setVisibility(8);
        ((CompoundButton) this.mCutterTypeChekBox).setChecked(true);
    }

    private View eraseByStroke() {
        CheckBox typeCheckBox = new CheckBox(this.mContext);
        RelativeLayout.LayoutParams typeCheckBoxParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(50.0f));
        typeCheckBoxParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(11.0f), this.mDrawableImg.getIntValueAppliedDensity(76.0f), this.mDrawableImg.getIntValueAppliedDensity(16.0f), this.mDrawableImg.getIntValueAppliedDensity(11.0f));
        typeCheckBox.setLayoutParams(typeCheckBoxParams);
        typeCheckBox.setFocusable(true);
        typeCheckBox.setSingleLine(true);
        typeCheckBox.setEllipsize(TextUtils.TruncateAt.END);
        typeCheckBox.setText(this.mStringUtil.setString("string_erase_line_by_line"));
        typeCheckBox.setButtonDrawable(this.mDrawableImg.setDrawableCheckedImg("snote_btn_check_off", "snote_btn_check_on", "snote_btn_check_on_focused", "snote_btn_check_off_focused", 25, 25));
        typeCheckBox.setPadding(this.mDrawableImg.getIntValueAppliedDensity(30.0f), 0, 0, 0);
        typeCheckBox.setTextColor(-16777216);
        typeCheckBox.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(20.0f));
        typeCheckBox.setChecked(true);
        return typeCheckBox;
    }

    public void setPopup(boolean open) {
        if (open) {
            this.mPopupMaxButton.setVisibility(8);
            this.mPopupMinButton.setVisibility(0);
            playScrollAnimationForBottomBar(2, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(236.0f));
        } else {
            this.mPopupMaxButton.setVisibility(0);
            this.mPopupMinButton.setVisibility(8);
            playScrollAnimationForBottomBar(2, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        }
    }

    class RptUpdater implements Runnable {
        RptUpdater() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (SpenSettingRemoverLayout2.this.mAutoIncrement) {
                    if (SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size < 10.0f) {
                        SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size += (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f) * 1.0f;
                        SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.incrementProgressBy(1);
                        SpenSettingRemoverLayout2.this.mSettingInfo.size = SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size;
                    }
                    SpenSettingRemoverLayout2.this.repeatUpdateHandler.postDelayed(SpenSettingRemoverLayout2.this.new RptUpdater(), 20L);
                    return;
                }
                if (SpenSettingRemoverLayout2.this.mAutoDecrement) {
                    if (SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                        SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size -= (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f) * 1.0f;
                        SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.incrementProgressBy(-1);
                        SpenSettingRemoverLayout2.this.mSettingInfo.size = SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size;
                    }
                    SpenSettingRemoverLayout2.this.repeatUpdateHandler.postDelayed(SpenSettingRemoverLayout2.this.new RptUpdater(), 20L);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    public SpenSettingRemoverLayout2(Context context, String customImagePath, RelativeLayout relativeLayout) {
        super(context);
        this.mPopupListener = null;
        this.requestLayoutDisable = false;
        this.mScale = 1.0f;
        this.mCurrentEraserType = 0;
        this.mSettingInfo = null;
        this.mCutterDataList = null;
        this.mCurrentCutterType = 0;
        this.mMoveErasersettingLayout = false;
        this.mFirstLongPress = true;
        this.mImageLoader = null;
        this.mEraserListener = null;
        this.mActionListener = null;
        this.mViewMode = 0;
        this.mCanvasSize = 1080;
        this.mHandler = new Handler();
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        };
        this.mClearAllListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingRemoverLayout2.this.mEraserListener != null) {
                    SpenSettingRemoverLayout2.this.mEraserListener.onClearAll();
                }
            }
        };
        this.mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SpenSettingRemoverInfo info;
                if (SpenSettingRemoverLayout2.this.mCanvasView != null && (info = SpenSettingRemoverLayout2.this.mCanvasView.getRemoverSettingInfo()) != null) {
                    if (isChecked) {
                        SpenSettingRemoverInfo spenSettingRemoverInfo = SpenSettingRemoverLayout2.this.mSettingInfo;
                        info.type = 1;
                        spenSettingRemoverInfo.type = 1;
                        SpenSettingRemoverLayout2.this.setEnableSizeSeekbar(false);
                        SpenSettingRemoverLayout2.this.playSoundEffect(0);
                    } else {
                        SpenSettingRemoverInfo spenSettingRemoverInfo2 = SpenSettingRemoverLayout2.this.mSettingInfo;
                        info.type = 0;
                        spenSettingRemoverInfo2.type = 0;
                        SpenSettingRemoverLayout2.this.setEnableSizeSeekbar(true);
                        SpenSettingRemoverLayout2.this.playSoundEffect(0);
                    }
                    SpenSettingRemoverLayout2.this.mCanvasView.setRemoverSettingInfo(info);
                }
            }
        };
        this.mPopupButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SpenSettingRemoverLayout2.this.mPopupMaxButton) {
                    if (SpenSettingRemoverLayout2.this.mPopupListener != null) {
                        SpenSettingRemoverLayout2.this.mPopupListener.onPopup(true);
                    }
                } else if (v == SpenSettingRemoverLayout2.this.mPopupMinButton && SpenSettingRemoverLayout2.this.mPopupListener != null) {
                    SpenSettingRemoverLayout2.this.mPopupListener.onPopup(false);
                }
            }
        };
        this.mPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.incrementProgressBy(1);
                int progress = SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getProgress();
                if (progress >= SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getMax()) {
                    SpenSettingRemoverLayout2.this.mEraserPlusButton.setEnabled(false);
                } else {
                    SpenSettingRemoverLayout2.this.mEraserPlusButton.setEnabled(true);
                }
                if (SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size < 10.0f) {
                    SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size += 1.0f * (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f);
                    SpenSettingRemoverLayout2.this.mSettingInfo.size = SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size;
                }
            }
        };
        this.mMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.incrementProgressBy(-1);
                int progress = SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getProgress();
                if (progress <= 0) {
                    SpenSettingRemoverLayout2.this.mEraserMinusButton.setEnabled(false);
                } else {
                    SpenSettingRemoverLayout2.this.mEraserMinusButton.setEnabled(true);
                }
                if (SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size -= 1.0f * (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f);
                    SpenSettingRemoverLayout2.this.mSettingInfo.size = SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size;
                }
            }
        };
        this.repeatUpdateHandler = new Handler();
        this.mAutoIncrement = false;
        this.mAutoDecrement = false;
        this.mLongClickPlusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingRemoverLayout2.this.mAutoIncrement = true;
                SpenSettingRemoverLayout2.this.mEraserPlusButton.setSelected(true);
                SpenSettingRemoverLayout2.this.repeatUpdateHandler.post(SpenSettingRemoverLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchPlusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingRemoverLayout2.this.mAutoIncrement) {
                    SpenSettingRemoverLayout2.this.mEraserPlusButton.setSelected(false);
                    SpenSettingRemoverLayout2.this.mAutoIncrement = false;
                }
                return false;
            }
        };
        this.mLongClickMinusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingRemoverLayout2.this.mAutoDecrement = true;
                SpenSettingRemoverLayout2.this.mEraserMinusButton.setSelected(true);
                SpenSettingRemoverLayout2.this.repeatUpdateHandler.post(SpenSettingRemoverLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchMinusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingRemoverLayout2.this.mAutoDecrement) {
                    SpenSettingRemoverLayout2.this.mEraserMinusButton.setSelected(false);
                    SpenSettingRemoverLayout2.this.mAutoDecrement = false;
                }
                return false;
            }
        };
        this.mEraserSizeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.11
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingRemoverInfo info;
                if (SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType] != null) {
                    SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size = (((progress + 1) * 10.0f) / 10.0f) * (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f);
                }
                int currentType = 1;
                SpenSettingRemoverLayout2.this.requestLayoutDisable = fromUser;
                SpenSettingRemoverLayout2.this.mEraserSizeTextView.setText(String.valueOf(progress + 1));
                int seek_label_pos = SpenSettingRemoverLayout2.this.mDrawableImg.getIntValueAppliedDensity(41.0f) + ((int) ((SpenSettingRemoverLayout2.this.mDrawableImg.getIntValueAppliedDensity(200.0f) * (progress / 9.0f)) + SpenSettingRemoverLayout2.this.mDrawableImg.getIntValueAppliedDensity(15.0f)));
                SpenSettingRemoverLayout2.this.mEraserSizeTextView.setX(seek_label_pos);
                SpenSettingRemoverLayout2.this.mEraserSizeTextView.setY(SpenSettingRemoverLayout2.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                if (SpenSettingRemoverLayout2.this.mCanvasView != null && (info = SpenSettingRemoverLayout2.this.mCanvasView.getRemoverSettingInfo()) != null) {
                    SpenSettingRemoverInfo spenSettingRemoverInfo = SpenSettingRemoverLayout2.this.mSettingInfo;
                    float f = (((progress + 1) * 10.0f) / 10.0f) * (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f);
                    info.size = f;
                    spenSettingRemoverInfo.size = f;
                    SpenSettingRemoverInfo spenSettingRemoverInfo2 = SpenSettingRemoverLayout2.this.mSettingInfo;
                    currentType = info.type;
                    spenSettingRemoverInfo2.type = currentType;
                    SpenSettingRemoverLayout2.this.mCanvasView.setRemoverSettingInfo(info);
                }
                SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.setContentDescription(String.valueOf(SpenSettingRemoverLayout2.this.mEraserSizeTextView.getText().toString()) + "\u0000");
                if (currentType != 1) {
                    if (SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getProgress() == SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getMax()) {
                        SpenSettingRemoverLayout2.this.mEraserPlusButton.setSelected(false);
                        SpenSettingRemoverLayout2.this.mEraserPlusButton.setEnabled(false);
                        if (SpenSettingRemoverLayout2.this.mAutoIncrement) {
                            SpenSettingRemoverLayout2.this.mAutoIncrement = false;
                        }
                    } else {
                        SpenSettingRemoverLayout2.this.mEraserPlusButton.setEnabled(true);
                    }
                    if (SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getProgress() == 0) {
                        SpenSettingRemoverLayout2.this.mEraserMinusButton.setSelected(false);
                        SpenSettingRemoverLayout2.this.mEraserMinusButton.setEnabled(false);
                        if (SpenSettingRemoverLayout2.this.mAutoDecrement) {
                            SpenSettingRemoverLayout2.this.mAutoDecrement = false;
                            return;
                        }
                        return;
                    }
                    SpenSettingRemoverLayout2.this.mEraserMinusButton.setEnabled(true);
                }
            }
        };
        this.mEraserTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout2.this.eraserTypeSetting(v);
            }
        };
        this.mEraserKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.13
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.isFocused() && event.getAction() == 0) {
                            SpenSettingRemoverLayout2.this.mEraserMinusButton.performClick();
                            break;
                        }
                        break;
                    case 22:
                        if (SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.isFocused() && event.getAction() == 0) {
                            SpenSettingRemoverLayout2.this.mEraserPlusButton.performClick();
                            break;
                        }
                        break;
                }
                return true;
            }
        };
        this.requestLayoutDisable = false;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, 1.0f);
        this.mStringUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mContext = context;
        this.mCanvasLayout = relativeLayout;
        initButtonValue();
        initView();
        setListener();
        this.mMovableRect = new Rect();
    }

    public SpenSettingRemoverLayout2(Context context, String customImagePath, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.mPopupListener = null;
        this.requestLayoutDisable = false;
        this.mScale = 1.0f;
        this.mCurrentEraserType = 0;
        this.mSettingInfo = null;
        this.mCutterDataList = null;
        this.mCurrentCutterType = 0;
        this.mMoveErasersettingLayout = false;
        this.mFirstLongPress = true;
        this.mImageLoader = null;
        this.mEraserListener = null;
        this.mActionListener = null;
        this.mViewMode = 0;
        this.mCanvasSize = 1080;
        this.mHandler = new Handler();
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        };
        this.mClearAllListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingRemoverLayout2.this.mEraserListener != null) {
                    SpenSettingRemoverLayout2.this.mEraserListener.onClearAll();
                }
            }
        };
        this.mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SpenSettingRemoverInfo info;
                if (SpenSettingRemoverLayout2.this.mCanvasView != null && (info = SpenSettingRemoverLayout2.this.mCanvasView.getRemoverSettingInfo()) != null) {
                    if (isChecked) {
                        SpenSettingRemoverInfo spenSettingRemoverInfo = SpenSettingRemoverLayout2.this.mSettingInfo;
                        info.type = 1;
                        spenSettingRemoverInfo.type = 1;
                        SpenSettingRemoverLayout2.this.setEnableSizeSeekbar(false);
                        SpenSettingRemoverLayout2.this.playSoundEffect(0);
                    } else {
                        SpenSettingRemoverInfo spenSettingRemoverInfo2 = SpenSettingRemoverLayout2.this.mSettingInfo;
                        info.type = 0;
                        spenSettingRemoverInfo2.type = 0;
                        SpenSettingRemoverLayout2.this.setEnableSizeSeekbar(true);
                        SpenSettingRemoverLayout2.this.playSoundEffect(0);
                    }
                    SpenSettingRemoverLayout2.this.mCanvasView.setRemoverSettingInfo(info);
                }
            }
        };
        this.mPopupButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SpenSettingRemoverLayout2.this.mPopupMaxButton) {
                    if (SpenSettingRemoverLayout2.this.mPopupListener != null) {
                        SpenSettingRemoverLayout2.this.mPopupListener.onPopup(true);
                    }
                } else if (v == SpenSettingRemoverLayout2.this.mPopupMinButton && SpenSettingRemoverLayout2.this.mPopupListener != null) {
                    SpenSettingRemoverLayout2.this.mPopupListener.onPopup(false);
                }
            }
        };
        this.mPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.incrementProgressBy(1);
                int progress = SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getProgress();
                if (progress >= SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getMax()) {
                    SpenSettingRemoverLayout2.this.mEraserPlusButton.setEnabled(false);
                } else {
                    SpenSettingRemoverLayout2.this.mEraserPlusButton.setEnabled(true);
                }
                if (SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size < 10.0f) {
                    SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size += 1.0f * (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f);
                    SpenSettingRemoverLayout2.this.mSettingInfo.size = SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size;
                }
            }
        };
        this.mMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.incrementProgressBy(-1);
                int progress = SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getProgress();
                if (progress <= 0) {
                    SpenSettingRemoverLayout2.this.mEraserMinusButton.setEnabled(false);
                } else {
                    SpenSettingRemoverLayout2.this.mEraserMinusButton.setEnabled(true);
                }
                if (SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size -= 1.0f * (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f);
                    SpenSettingRemoverLayout2.this.mSettingInfo.size = SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size;
                }
            }
        };
        this.repeatUpdateHandler = new Handler();
        this.mAutoIncrement = false;
        this.mAutoDecrement = false;
        this.mLongClickPlusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingRemoverLayout2.this.mAutoIncrement = true;
                SpenSettingRemoverLayout2.this.mEraserPlusButton.setSelected(true);
                SpenSettingRemoverLayout2.this.repeatUpdateHandler.post(SpenSettingRemoverLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchPlusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingRemoverLayout2.this.mAutoIncrement) {
                    SpenSettingRemoverLayout2.this.mEraserPlusButton.setSelected(false);
                    SpenSettingRemoverLayout2.this.mAutoIncrement = false;
                }
                return false;
            }
        };
        this.mLongClickMinusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingRemoverLayout2.this.mAutoDecrement = true;
                SpenSettingRemoverLayout2.this.mEraserMinusButton.setSelected(true);
                SpenSettingRemoverLayout2.this.repeatUpdateHandler.post(SpenSettingRemoverLayout2.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchMinusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingRemoverLayout2.this.mAutoDecrement) {
                    SpenSettingRemoverLayout2.this.mEraserMinusButton.setSelected(false);
                    SpenSettingRemoverLayout2.this.mAutoDecrement = false;
                }
                return false;
            }
        };
        this.mEraserSizeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.11
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingRemoverInfo info;
                if (SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType] != null) {
                    SpenSettingRemoverLayout2.this.mCutterDataList[SpenSettingRemoverLayout2.this.mCurrentCutterType].size = (((progress + 1) * 10.0f) / 10.0f) * (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f);
                }
                int currentType = 1;
                SpenSettingRemoverLayout2.this.requestLayoutDisable = fromUser;
                SpenSettingRemoverLayout2.this.mEraserSizeTextView.setText(String.valueOf(progress + 1));
                int seek_label_pos = SpenSettingRemoverLayout2.this.mDrawableImg.getIntValueAppliedDensity(41.0f) + ((int) ((SpenSettingRemoverLayout2.this.mDrawableImg.getIntValueAppliedDensity(200.0f) * (progress / 9.0f)) + SpenSettingRemoverLayout2.this.mDrawableImg.getIntValueAppliedDensity(15.0f)));
                SpenSettingRemoverLayout2.this.mEraserSizeTextView.setX(seek_label_pos);
                SpenSettingRemoverLayout2.this.mEraserSizeTextView.setY(SpenSettingRemoverLayout2.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                if (SpenSettingRemoverLayout2.this.mCanvasView != null && (info = SpenSettingRemoverLayout2.this.mCanvasView.getRemoverSettingInfo()) != null) {
                    SpenSettingRemoverInfo spenSettingRemoverInfo = SpenSettingRemoverLayout2.this.mSettingInfo;
                    float f = (((progress + 1) * 10.0f) / 10.0f) * (SpenSettingRemoverLayout2.this.mCanvasSize / 1080.0f);
                    info.size = f;
                    spenSettingRemoverInfo.size = f;
                    SpenSettingRemoverInfo spenSettingRemoverInfo2 = SpenSettingRemoverLayout2.this.mSettingInfo;
                    currentType = info.type;
                    spenSettingRemoverInfo2.type = currentType;
                    SpenSettingRemoverLayout2.this.mCanvasView.setRemoverSettingInfo(info);
                }
                SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.setContentDescription(String.valueOf(SpenSettingRemoverLayout2.this.mEraserSizeTextView.getText().toString()) + "\u0000");
                if (currentType != 1) {
                    if (SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getProgress() == SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getMax()) {
                        SpenSettingRemoverLayout2.this.mEraserPlusButton.setSelected(false);
                        SpenSettingRemoverLayout2.this.mEraserPlusButton.setEnabled(false);
                        if (SpenSettingRemoverLayout2.this.mAutoIncrement) {
                            SpenSettingRemoverLayout2.this.mAutoIncrement = false;
                        }
                    } else {
                        SpenSettingRemoverLayout2.this.mEraserPlusButton.setEnabled(true);
                    }
                    if (SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.getProgress() == 0) {
                        SpenSettingRemoverLayout2.this.mEraserMinusButton.setSelected(false);
                        SpenSettingRemoverLayout2.this.mEraserMinusButton.setEnabled(false);
                        if (SpenSettingRemoverLayout2.this.mAutoDecrement) {
                            SpenSettingRemoverLayout2.this.mAutoDecrement = false;
                            return;
                        }
                        return;
                    }
                    SpenSettingRemoverLayout2.this.mEraserMinusButton.setEnabled(true);
                }
            }
        };
        this.mEraserTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout2.this.eraserTypeSetting(v);
            }
        };
        this.mEraserKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.13
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.isFocused() && event.getAction() == 0) {
                            SpenSettingRemoverLayout2.this.mEraserMinusButton.performClick();
                            break;
                        }
                        break;
                    case 22:
                        if (SpenSettingRemoverLayout2.this.mEraserSizeSeekBar.isFocused() && event.getAction() == 0) {
                            SpenSettingRemoverLayout2.this.mEraserPlusButton.performClick();
                            break;
                        }
                        break;
                }
                return true;
            }
        };
        this.requestLayoutDisable = false;
        this.mScale = ratio;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, ratio);
        this.mStringUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mContext = context;
        this.mCanvasLayout = relativeLayout;
        initButtonValue();
        initView();
        setListener();
        this.mMovableRect = new Rect();
    }

    private void totalLayout() {
        setLayoutParams(new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), -2));
        setOrientation(1);
        this.mTitleLayout = titleLayout();
        this.mBodyLayout = bodyLayout();
        addView(this.mTitleLayout);
        addView(this.mBodyLayout);
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
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ImageView titleLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleLeftParam = new RelativeLayout.LayoutParams(-1, -1);
        titleLeftParam.alignWithParent = true;
        titleLeftParam.addRule(9);
        titleLeftParam.addRule(10);
        titleLeft.setLayoutParams(titleLeftParam);
        ImageView titleRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(164.5f), -1);
        titleRightParam.alignWithParent = true;
        titleRightParam.addRule(11);
        titleRightParam.addRule(10);
        titleRight.setLayoutParams(titleRightParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(titleLeft, titleLeftPath);
        relativeLayout.addView(titleLeft);
        return relativeLayout;
    }

    private View titleText() throws Resources.NotFoundException {
        TextView titleView = new TextView(this.mContext);
        titleView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(42.0f)));
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
            titleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(20.0f));
        }
        titleView.setContentDescription(this.mStringUtil.setString("string_eraser_settings"));
        titleView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(13.0f), 0, 0, 0);
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
        this.mCutterTypeChekBox = eraseByStroke();
        setEnableSizeSeekbar(false);
        layout.addView(this.mEraserTypeLayout);
        layout.addView(this.mSettingSizeLayout);
        layout.addView(this.mCutterTypeChekBox);
        layout.addView(this.mClearAllButton);
        return layout;
    }

    private ViewGroup bodyBg() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setLayoutParams(layoutParams);
        ImageView bodyLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyLeftParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), this.mDrawableImg.getIntValueAppliedDensity(144.0f));
        bodyLeftParam.alignWithParent = true;
        bodyLeftParam.addRule(9);
        bodyLeftParam.addRule(10);
        bodyLeft.setLayoutParams(bodyLeftParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyLeft, bodyLeftPath);
        linearLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        linearLayout.addView(bodyLeft);
        return linearLayout;
    }

    private void initButtonValue() {
        this.EXIT_BUTTON_TOP_MARGIN = 10.0f - ((this.mScale - 1.0f) * 6.0f);
        this.EXIT_BUTTON_RIGHT_MARGIN = 4.3333335f - ((this.mScale - 1.0f) * 1.8333334f);
        this.EXIT_BUTTON_WIDTH = Math.round((38.0f * (42.0f - this.EXIT_BUTTON_TOP_MARGIN)) / 36.0f);
        this.EXIT_BUTTON_HEIGHT = 36;
        this.LINE_BUTTON_TOP_MARGIN = 17.0f - ((this.mScale - 1.0f) * 2.0f);
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

    public void close() {
        this.mCanvasView = null;
        this.mCanvasLayout = null;
        this.mContext = null;
        if (this.mDrawableImg != null) {
            this.mDrawableImg.unbindDrawables(this.mEraserSizeSeekBar);
            this.mEraserSizeSeekBar = null;
            this.mDrawableImg.unbindDrawables(this.mEraserSizeButtonSeekbar);
            this.mEraserSizeButtonSeekbar = null;
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
            if (this.mCutterDataList != null) {
                this.mCutterDataList[0] = null;
                this.mCutterDataList[1] = null;
                this.mCutterDataList = null;
            }
            this.mEraserListener = null;
            this.mActionListener = null;
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
        this.mEraserSizeSeekBar.setMax(9);
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
            this.mTitleLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        }
        if (this.mPopupMaxButton != null) {
            this.mPopupMaxButton.setOnClickListener(this.mPopupButtonListener);
        }
        if (this.mPopupMinButton != null) {
            this.mPopupMinButton.setOnClickListener(this.mPopupButtonListener);
        }
        if (this.mEraserMinusButton != null) {
            this.mEraserMinusButton.setOnClickListener(this.mMinusButtonListener);
            this.mEraserMinusButton.setOnLongClickListener(this.mLongClickMinusButtonListener);
            this.mEraserMinusButton.setOnTouchListener(this.mTouchMinusButtonListener);
        }
        if (this.mEraserPlusButton != null) {
            this.mEraserPlusButton.setOnClickListener(this.mPlusButtonListener);
            this.mEraserPlusButton.setOnLongClickListener(this.mLongClickPlusButtonListener);
            this.mEraserPlusButton.setOnTouchListener(this.mTouchPlusButtonListener);
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
        ((CheckBox) this.mCutterTypeChekBox).setOnCheckedChangeListener(this.mCheckedChangeListener);
    }

    public void setIndicatorPosition(int x) {
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
        this.mImageLoader.addViewBackgroundSelectableImageLoad(popupMinButton, popupMinPath, popupMinPath, popupMinPath, 32, 32);
        return popupMinButton;
    }

    private ViewGroup eraserTypeLayout() {
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        localLinearLayout.setOrientation(0);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLinearLayout.setLayoutParams(localLayoutParams);
        this.mEraserType01 = new ImageButton(this.mContext);
        this.mEraserType01.setImageDrawable(this.mDrawableImg.setDrawableImg(eraserPopupDrawUnselect));
        this.mEraserType01.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        SpenSettingRemoverLayout2.this.mEraserType01.setImageDrawable(SpenSettingRemoverLayout2.this.mDrawableImg.setDrawableImg(SpenSettingRemoverLayout2.eraserPopupDrawPress));
                        break;
                    case 1:
                        SpenSettingRemoverLayout2.this.mEraserType01.setImageDrawable(SpenSettingRemoverLayout2.this.mDrawableImg.setDrawableImg(SpenSettingRemoverLayout2.eraserPopupDrawUnselect));
                        break;
                }
                return false;
            }
        });
        localLinearLayout.addView(this.mEraserType01);
        this.mEraserType02 = new ImageButton(this.mContext);
        this.mEraserType02.setImageDrawable(this.mDrawableImg.setDrawableImg(eraserPopupTextUnselect));
        this.mEraserType02.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        SpenSettingRemoverLayout2.this.mEraserType02.setImageDrawable(SpenSettingRemoverLayout2.this.mDrawableImg.setDrawableImg(SpenSettingRemoverLayout2.eraserPopupTextPress));
                        break;
                    case 1:
                        SpenSettingRemoverLayout2.this.mEraserType02.setImageDrawable(SpenSettingRemoverLayout2.this.mDrawableImg.setDrawableImg(SpenSettingRemoverLayout2.eraserPopupTextUnselect));
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
        RelativeLayout.LayoutParams eraserSettingSizeLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(62.0f));
        eraserSettingSizeLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(11.0f), 0, 0);
        eraserSettingSizeLayout.setLayoutParams(eraserSettingSizeLayoutParams);
        this.mEraserSizeTextView = new TextView(this.mContext);
        this.mEraserSizeTextView.setTypeface(Typeface.SANS_SERIF, 1);
        this.mEraserSizeTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mEraserSizeTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        RelativeLayout.LayoutParams eraserSizeTextParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(50.0f), this.mDrawableImg.getIntValueAppliedDensity(13.0f));
        eraserSizeTextParam.addRule(4);
        this.mEraserSizeTextView.setLayoutParams(eraserSizeTextParam);
        eraserSettingSizeLayout.addView(this.mEraserSizeTextView);
        this.mEraserSizeTextView.setVisibility(8);
        this.mEraserSizeButtonSeekbar = eraserSizeButtonSeekbar();
        eraserSettingSizeLayout.addView(this.mEraserSizeButtonSeekbar);
        return eraserSettingSizeLayout;
    }

    private SeekBar eraserSettingSizeSeekBar() throws Resources.NotFoundException, IOException {
        SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(229.0f), this.mDrawableImg.getIntValueAppliedDensity(33.0f));
        seekBarParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(2.0f), this.mDrawableImg.getIntValueAppliedDensity(3.0f), this.mDrawableImg.getIntValueAppliedDensity(2.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        seekBarParams.alignWithParent = true;
        seekBarParams.addRule(14);
        seekBarParams.addRule(8);
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(this.mDrawableImg.getIntValueAppliedDensity(15.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(15.0f), 0);
        seekBar.setMax(9);
        seekBar.setThumb(this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 33, 33));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(0);
        localGradientDrawable.setCornerRadius(this.mDrawableImg.getIntValueAppliedDensity(7.0f));
        ClipDrawable localClipDrawable = new ClipDrawable(localGradientDrawable, 3, 1);
        Drawable bgDrawable = this.mDrawableImg.setDrawableImg(progressBgPath, 229, 12);
        Drawable shadowDrawable = this.mDrawableImg.setDrawableImg(progressShadowPath, 229, 12);
        InsetDrawable bgInsetDrawable = new InsetDrawable(bgDrawable, 0, 0, 0, 0);
        InsetDrawable shadowInsetDrawable = new InsetDrawable(shadowDrawable, 0, 0, 0, 0);
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[]{bgInsetDrawable, shadowInsetDrawable, localClipDrawable});
        seekBar.setProgressDrawable(localLayerDrawable);
        return seekBar;
    }

    private ViewGroup eraserSizeButtonSeekbar() {
        RelativeLayout eraserSettingSizeDisplayLayout = new RelativeLayout(this.mContext);
        this.mEraserPlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams eraserPlusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(36.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        eraserPlusImageParam.alignWithParent = true;
        eraserPlusImageParam.addRule(11);
        eraserPlusImageParam.addRule(8);
        eraserPlusImageParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(2.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(8.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        this.mEraserPlusButton.setLayoutParams(eraserPlusImageParam);
        this.mEraserPlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        if (mSdkVersion < 16) {
            this.mEraserPlusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 36, 36));
        } else {
            this.mEraserPlusButton.setBackground(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 36, 36));
        }
        this.mEraserMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams eraserMinusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(36.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        eraserMinusImageParam.alignWithParent = true;
        eraserMinusImageParam.addRule(9);
        eraserMinusImageParam.addRule(8);
        eraserMinusImageParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(8.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(2.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        this.mEraserMinusButton.setLayoutParams(eraserMinusImageParam);
        this.mEraserMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        if (mSdkVersion < 16) {
            this.mEraserMinusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 36, 36));
        } else {
            this.mEraserMinusButton.setBackground(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 36, 36));
        }
        this.mEraserSizeSeekBar = eraserSettingSizeSeekBar();
        eraserSettingSizeDisplayLayout.addView(this.mEraserSizeSeekBar);
        eraserSettingSizeDisplayLayout.addView(this.mEraserPlusButton);
        eraserSettingSizeDisplayLayout.addView(this.mEraserMinusButton);
        return eraserSettingSizeDisplayLayout;
    }

    private View eraserSettingClearAllButton() {
        Button clearAllButton = new Button(this.mContext);
        RelativeLayout.LayoutParams clearAllButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(307.0f), this.mDrawableImg.getIntValueAppliedDensity(47.0f));
        clearAllButtonParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(11.0f), this.mDrawableImg.getIntValueAppliedDensity(136.0f), this.mDrawableImg.getIntValueAppliedDensity(16.0f), this.mDrawableImg.getIntValueAppliedDensity(11.0f));
        clearAllButton.setLayoutParams(clearAllButtonParams);
        clearAllButton.setFocusable(true);
        clearAllButton.setText(this.mStringUtil.setString("string_clear_all"));
        int[] arrayOfStates1 = {R.attr.state_pressed};
        int[][] arrayOfStates = {arrayOfStates1, new int[0]};
        int[] textColor = {-1, -16777216};
        clearAllButton.setTextColor(new ColorStateList(arrayOfStates, textColor));
        clearAllButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(17.0f));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(clearAllButton, btnNoramlPath, btnPressPath, btnFocusPath);
        return clearAllButton;
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
        this.mScrollTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.16
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Handler handler = SpenSettingRemoverLayout2.this.mHandler;
                final int i = from;
                final int i2 = to;
                handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenSettingRemoverLayout2.this.mCount += 5;
                        if (i > i2) {
                            int pos = i - SpenSettingRemoverLayout2.this.mCount;
                            SpenSettingRemoverLayout2.this.setLayoutHeight(pos);
                            if (pos <= i2) {
                                SpenSettingRemoverLayout2.this.setLayoutHeight(i2);
                                if (SpenSettingRemoverLayout2.this.mScrollTimer != null) {
                                    SpenSettingRemoverLayout2.this.mScrollTimer.cancel();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int pos2 = i + SpenSettingRemoverLayout2.this.mCount;
                        SpenSettingRemoverLayout2.this.setLayoutHeight(pos2);
                        if (pos2 >= i2) {
                            SpenSettingRemoverLayout2.this.setLayoutHeight(i2);
                            if (SpenSettingRemoverLayout2.this.mScrollTimer != null) {
                                SpenSettingRemoverLayout2.this.mScrollTimer.cancel();
                            }
                        }
                    }
                });
            }
        }, 10L, delay);
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
        Log.v(TAG, "==== SettingEraser ====");
        Log.i(TAG, "old  = " + this.mMovableRect.left + ", " + this.mMovableRect.top + ", " + this.mMovableRect.right + ", " + this.mMovableRect.bottom);
        Log.e(TAG, "new  = " + newMovableRect.left + ", " + newMovableRect.top + ", " + newMovableRect.right + ", " + newMovableRect.bottom);
        Rect r = new Rect();
        int[] location = new int[2];
        getLocationOnScreen(location);
        r.left = location[0];
        r.top = location[1];
        r.right = r.left + getWidth();
        r.bottom = r.top + getHeight();
        Log.d(TAG, "view = " + r.left + ", " + r.top + ", " + r.right + ", " + r.bottom);
        float left = r.left - this.mMovableRect.left;
        float right = this.mMovableRect.right - r.right;
        float top = r.top - this.mMovableRect.top;
        float bottom = this.mMovableRect.bottom - r.bottom;
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
        Log.e(TAG, "lMargin = " + params.leftMargin + ", tMargin = " + params.topMargin);
        setLayoutParams(params);
    }

    private void checkPosition() {
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
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int minWidth = this.mDrawableImg.getIntValueAppliedDensity(228.0f);
        int minHeight = this.mDrawableImg.getIntValueAppliedDensity(129.0f);
        if (w < minWidth || h < minHeight) {
            this.mMovableRect.set(getMovableRect());
            checkPosition();
        }
        Handler handler = new Handler();
        handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.17
            @Override // java.lang.Runnable
            public void run() {
                SpenSettingRemoverLayout2.this.requestLayout();
            }
        });
        super.onSizeChanged(w, h, oldw, oldh);
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
            this.mEraserSizeTextView.setText(String.valueOf(this.mEraserSizeSeekBar.getProgress() + 1));
            int seek_label_pos = this.mDrawableImg.getIntValueAppliedDensity(41.0f) + ((int) ((this.mDrawableImg.getIntValueAppliedDensity(200.0f) * (this.mEraserSizeSeekBar.getProgress() / 100.0f)) + this.mDrawableImg.getIntValueAppliedDensity(15.0f)));
            this.mEraserSizeTextView.setX(seek_label_pos);
            this.mEraserSizeTextView.setY(this.mDrawableImg.getIntValueAppliedDensity(5.0f));
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
            this.mCutterDataList[this.mCurrentCutterType].size = settingCutterInfo.size * (this.mCanvasSize / 1080.0f);
            this.mEraserSizeSeekBar.setProgress((((int) settingCutterInfo.size) * 10) / 10);
            this.mSettingInfo.size = settingCutterInfo.size;
            this.mSettingInfo.type = settingCutterInfo.type;
        }
    }

    public void setEraserInfoList(SpenSettingRemoverInfo[] list) {
        if (list != null) {
            this.mCutterDataList = list;
        }
    }

    public void setEraserListener(EventListener listener) {
        if (listener != null) {
            this.mEraserListener = listener;
        }
    }

    public void setPopupListenr(PopupListener listener) {
        if (listener != null) {
            this.mPopupListener = listener;
        }
    }

    public void setActionListener(ActionListener listener) {
        if (listener != null) {
            this.mActionListener = listener;
        }
    }
}
