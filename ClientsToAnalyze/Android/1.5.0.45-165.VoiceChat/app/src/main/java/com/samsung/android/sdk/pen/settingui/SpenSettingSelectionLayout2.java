package com.samsung.android.sdk.pen.settingui;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
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
import com.samsung.android.sdk.pen.util.SpenFont;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
class SpenSettingSelectionLayout2 extends LinearLayout {
    protected static final int BODY_LAYOUT_HEIGHT = 120;
    protected static final int EXIT_BUTTON_RAW_HEIGHT = 42;
    protected static final int EXIT_BUTTON_RAW_WIDTH = 42;
    protected static final int TITLE_LAYOUT_HEIGHT = 42;
    public static final int VIEW_MODE_NORMAL = 0;
    public static final int VIEW_MODE_TITLE = 1;
    private static final String btnFocusPath = "snote_popup_btn_focus";
    private static final String btnNoramlPath = "snote_popup_btn_normal";
    private static final String btnPressPath = "snote_popup_btn_press";
    private static final String lassoPath = "snote_popup_icon_lasso";
    protected static final String mDefaultPath = "";
    private static final String popupMaxPath = "snote_popup_arrow_max_normal";
    private static final String popupMinPath = "snote_popup_arrow_min_normal";
    private static final String rectPath = "snote_popup_icon_rectangle";
    private static final String titleBodyPath = "vienna_popup_bg";
    private static final String titlePath = "vienna_popup_title_bg";
    protected int EXIT_BUTTON_HEIGHT;
    protected float EXIT_BUTTON_RIGHT_MARGIN;
    protected float EXIT_BUTTON_TOP_MARGIN;
    protected int EXIT_BUTTON_WIDTH;
    protected int LINE_BUTTON_HEIGHT;
    protected float LINE_BUTTON_TOP_MARGIN;
    protected int LINE_BUTTON_WIDTH;
    protected ActionListener mActionListener;
    protected View mBodyLayout;
    protected RelativeLayout mCanvasLayout;
    protected SpenSettingViewInterface mCanvasView;
    protected Context mContext;
    private int mCount;
    protected SPenImageUtil mDrawableImg;
    protected boolean mFirstLongPress;
    private final Handler mHandler;
    private SpenImageLoader mImageLoader;
    protected RelativeLayout mLassoButton;
    protected int mLeftMargin;
    protected Rect mMovableRect;
    protected boolean mMoveSelectionsettingLayout;
    private View.OnTouchListener mOnConsumedTouchListener;
    private final View.OnClickListener mPopupButtonListener;
    private PopupListener mPopupListener;
    protected View mPopupMaxButton;
    protected View mPopupMinButton;
    protected RelativeLayout mRectangleButton;
    protected float mScale;
    private Timer mScrollTimer;
    protected ViewGroup mSelectionTypeLayout;
    private View.OnClickListener mSelectionTypeListner;
    protected View[] mSelectionTypeView;
    protected SpenSettingSelectionInfo mSettingInfo;
    protected SPenTextUtil mStringUtil;
    protected View mTitleLayout;
    protected int mTopMargin;
    protected int mTotalLeftMargin;
    protected int mTotalTopMargin;
    protected int mViewMode;
    protected int mXDelta;
    protected int mYDelta;

    public interface ActionListener {
        void onMoved();
    }

    public interface PopupListener {
        void onPopup(boolean z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        if (!this.mFirstLongPress) {
            this.mMovableRect.set(getMovableRect());
            if (getVisibility() != 8) {
                rotatePosition();
            }
        }
        super.onConfigurationChanged(newConfig);
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
            playScrollAnimationForBottomBar(2, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(162.0f));
        } else {
            this.mPopupMaxButton.setVisibility(0);
            this.mPopupMinButton.setVisibility(8);
            playScrollAnimationForBottomBar(2, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        }
    }

    public SpenSettingSelectionLayout2(Context context, String customImagePath, RelativeLayout relativeLayout) {
        super(context);
        this.mScale = 1.0f;
        this.mPopupListener = null;
        this.mSettingInfo = null;
        this.mMoveSelectionsettingLayout = false;
        this.mFirstLongPress = true;
        this.mActionListener = null;
        this.mViewMode = 0;
        this.EXIT_BUTTON_RIGHT_MARGIN = 4.0f;
        this.mHandler = new Handler();
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        };
        this.mPopupButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SpenSettingSelectionLayout2.this.mPopupMaxButton) {
                    if (SpenSettingSelectionLayout2.this.mPopupListener != null) {
                        SpenSettingSelectionLayout2.this.mPopupListener.onPopup(true);
                    }
                } else if (v == SpenSettingSelectionLayout2.this.mPopupMinButton && SpenSettingSelectionLayout2.this.mPopupListener != null) {
                    SpenSettingSelectionLayout2.this.mPopupListener.onPopup(false);
                }
            }
        };
        this.mSelectionTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingSelectionLayout2.this.selectionTypeSetting(v);
            }
        };
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

    public SpenSettingSelectionLayout2(Context context, String customImagePath, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.mScale = 1.0f;
        this.mPopupListener = null;
        this.mSettingInfo = null;
        this.mMoveSelectionsettingLayout = false;
        this.mFirstLongPress = true;
        this.mActionListener = null;
        this.mViewMode = 0;
        this.EXIT_BUTTON_RIGHT_MARGIN = 4.0f;
        this.mHandler = new Handler();
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        };
        this.mPopupButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SpenSettingSelectionLayout2.this.mPopupMaxButton) {
                    if (SpenSettingSelectionLayout2.this.mPopupListener != null) {
                        SpenSettingSelectionLayout2.this.mPopupListener.onPopup(true);
                    }
                } else if (v == SpenSettingSelectionLayout2.this.mPopupMinButton && SpenSettingSelectionLayout2.this.mPopupListener != null) {
                    SpenSettingSelectionLayout2.this.mPopupListener.onPopup(false);
                }
            }
        };
        this.mSelectionTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingSelectionLayout2.this.selectionTypeSetting(v);
            }
        };
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
        setClickable(true);
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
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layout.setLayoutParams(layoutParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(layout, titlePath);
        return layout;
    }

    private View titleText() {
        TextView titleView = new TextView(this.mContext);
        titleView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(42.0f)));
        titleView.setTextColor(Color.rgb(250, 250, 250));
        titleView.setGravity(16);
        titleView.setFocusable(true);
        titleView.setSingleLine(true);
        titleView.setEllipsize(TextUtils.TruncateAt.END);
        titleView.setText(this.mStringUtil.setString("string_selection_mode"));
        titleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(20.0f));
        titleView.setTypeface(SpenFont.getTypeFace("Roboto-Regular"), 0);
        titleView.setContentDescription(this.mStringUtil.setString("string_selection_mode"));
        titleView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(13.0f), 0, 0, 0);
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
        ImageView bodyRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyRightParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(125.0f));
        bodyRightParam.alignWithParent = true;
        bodyRightParam.addRule(9);
        bodyRightParam.addRule(10);
        bodyRight.setLayoutParams(bodyRightParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyRight, titleBodyPath);
        linearLayout.addView(bodyRight);
        return linearLayout;
    }

    private void initButtonValue() {
        this.EXIT_BUTTON_TOP_MARGIN = 10.0f - ((this.mScale - 1.0f) * 2.0f);
        this.EXIT_BUTTON_RIGHT_MARGIN = this.mScale * 4.6666665f;
        this.EXIT_BUTTON_WIDTH = 42;
        this.EXIT_BUTTON_HEIGHT = 42;
    }

    public void close() {
        this.mCanvasView = null;
        this.mCanvasLayout = null;
        this.mContext = null;
        if (this.mDrawableImg != null) {
            this.mDrawableImg.unbindDrawables(this.mLassoButton);
            this.mLassoButton = null;
            this.mDrawableImg.unbindDrawables(this.mRectangleButton);
            this.mRectangleButton = null;
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
            this.mOnConsumedTouchListener = null;
            this.mSelectionTypeListner = null;
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
            this.mTitleLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        }
        if (this.mPopupMaxButton != null) {
            this.mPopupMaxButton.setOnClickListener(this.mPopupButtonListener);
        }
        if (this.mPopupMinButton != null) {
            this.mPopupMinButton.setOnClickListener(this.mPopupButtonListener);
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

    public void setIndicatorPosition(int position) {
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
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(-2, -1);
        exitButtonParams.addRule(11);
        exitButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(this.EXIT_BUTTON_RIGHT_MARGIN);
        popupMaxButton.setLayoutParams(exitButtonParams);
        popupMaxButton.setFocusable(true);
        popupMaxButton.setContentDescription(this.mStringUtil.setString("string_close"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(popupMaxButton, popupMaxPath, popupMaxPath, popupMaxPath, 42, 42);
        return popupMaxButton;
    }

    private View popupMinButton() {
        ImageButton popupMinButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(-2, -1);
        exitButtonParams.addRule(11);
        exitButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(this.EXIT_BUTTON_RIGHT_MARGIN);
        popupMinButton.setLayoutParams(exitButtonParams);
        popupMinButton.setFocusable(true);
        popupMinButton.setContentDescription(this.mStringUtil.setString("string_close"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(popupMinButton, popupMinPath, popupMinPath, popupMinPath, 42, 42);
        return popupMinButton;
    }

    private ViewGroup selectionTypeLayout() {
        RelativeLayout localLinearLayout = new RelativeLayout(this.mContext);
        localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(143.0f)));
        localLinearLayout.setPadding(0, this.mDrawableImg.getIntValueAppliedDensity(5.0f), 0, 0);
        RelativeLayout.LayoutParams lassoLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(47.0f));
        lassoLayoutParams.alignWithParent = true;
        lassoLayoutParams.addRule(9);
        lassoLayoutParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(11.0f), this.mDrawableImg.getIntValueAppliedDensity(7.0f), this.mDrawableImg.getIntValueAppliedDensity(15.0f), 0);
        int[] arrayOfStates1 = {R.attr.state_pressed};
        int[][] arrayOfStates = {arrayOfStates1, new int[0]};
        int[] textColor = {-1, -16777216};
        TextView txtLassoString = new TextView(this.mContext);
        txtLassoString.setText(this.mStringUtil.setString("string_lasso"));
        txtLassoString.setSingleLine(true);
        txtLassoString.setTextColor(new ColorStateList(arrayOfStates, textColor));
        txtLassoString.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(19.0f));
        txtLassoString.setTypeface(SpenFont.getTypeFace("Roboto-Regular"));
        txtLassoString.setCompoundDrawablesWithIntrinsicBounds(this.mDrawableImg.setDrawableImg(lassoPath, 36, 36), (Drawable) null, (Drawable) null, (Drawable) null);
        txtLassoString.setCompoundDrawablePadding(this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        txtLassoString.setGravity(17);
        txtLassoString.setPadding(this.mDrawableImg.getIntValueAppliedDensity(11.0f), this.mDrawableImg.getIntValueAppliedDensity(1.25f), 0, 0);
        this.mLassoButton = new RelativeLayout(this.mContext);
        this.mLassoButton.setFocusable(true);
        this.mLassoButton.setGravity(3);
        this.mLassoButton.setGravity(16);
        this.mLassoButton.setLayoutParams(lassoLayoutParams);
        this.mLassoButton.addView(txtLassoString);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mLassoButton, btnNoramlPath, btnPressPath, btnFocusPath);
        localLinearLayout.addView(this.mLassoButton);
        RelativeLayout.LayoutParams rectangleLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(47.0f));
        rectangleLayoutParams.alignWithParent = true;
        rectangleLayoutParams.addRule(11);
        rectangleLayoutParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(11.0f), this.mDrawableImg.getIntValueAppliedDensity(59.0f), this.mDrawableImg.getIntValueAppliedDensity(15.0f), 0);
        arrayOfStates1[0] = 16842919;
        arrayOfStates[0] = arrayOfStates1;
        arrayOfStates[1] = new int[0];
        textColor[0] = -1;
        textColor[1] = -16777216;
        TextView txtRectangleString = new TextView(this.mContext);
        txtRectangleString.setText(this.mStringUtil.setString("string_rectangle"));
        txtRectangleString.setSingleLine(true);
        txtRectangleString.setCompoundDrawablesWithIntrinsicBounds(this.mDrawableImg.setDrawableImg(rectPath, 36, 36), (Drawable) null, (Drawable) null, (Drawable) null);
        txtRectangleString.setCompoundDrawablePadding(this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        txtRectangleString.setTextColor(new ColorStateList(arrayOfStates, textColor));
        txtRectangleString.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(19.0f));
        txtLassoString.setTypeface(SpenFont.getTypeFace("Roboto-Regular"));
        txtRectangleString.setGravity(17);
        txtRectangleString.setPadding(this.mDrawableImg.getIntValueAppliedDensity(11.0f), this.mDrawableImg.getIntValueAppliedDensity(1.0f), 0, 0);
        this.mRectangleButton = new RelativeLayout(this.mContext);
        this.mRectangleButton.setFocusable(true);
        this.mRectangleButton.setGravity(3);
        this.mRectangleButton.setGravity(16);
        this.mRectangleButton.setLayoutParams(rectangleLayoutParams);
        this.mRectangleButton.addView(txtRectangleString);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mRectangleButton, btnNoramlPath, btnPressPath, btnFocusPath);
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
        this.mScrollTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Handler handler = SpenSettingSelectionLayout2.this.mHandler;
                final int i = from;
                final int i2 = to;
                handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenSettingSelectionLayout2.this.mCount += 5;
                        if (i > i2) {
                            int pos = i - SpenSettingSelectionLayout2.this.mCount;
                            SpenSettingSelectionLayout2.this.setLayoutHeight(pos);
                            if (pos <= i2) {
                                SpenSettingSelectionLayout2.this.setLayoutHeight(i2);
                                if (SpenSettingSelectionLayout2.this.mScrollTimer != null) {
                                    SpenSettingSelectionLayout2.this.mScrollTimer.cancel();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int pos2 = i + SpenSettingSelectionLayout2.this.mCount;
                        SpenSettingSelectionLayout2.this.setLayoutHeight(pos2);
                        if (pos2 >= i2) {
                            SpenSettingSelectionLayout2.this.setLayoutHeight(i2);
                            if (SpenSettingSelectionLayout2.this.mScrollTimer != null) {
                                SpenSettingSelectionLayout2.this.mScrollTimer.cancel();
                            }
                        }
                    }
                });
            }
        }, 10L, delay);
    }

    private void checkPosition() {
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
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int minWidth = this.mDrawableImg.getIntValueAppliedDensity(228.0f);
        int minHeight = this.mDrawableImg.getIntValueAppliedDensity(83.0f);
        if (w < minWidth || h < minHeight) {
            this.mMovableRect.set(getMovableRect());
            checkPosition();
        }
        Handler handler = new Handler();
        handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.5
            @Override // java.lang.Runnable
            public void run() {
                SpenSettingSelectionLayout2.this.requestLayout();
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
