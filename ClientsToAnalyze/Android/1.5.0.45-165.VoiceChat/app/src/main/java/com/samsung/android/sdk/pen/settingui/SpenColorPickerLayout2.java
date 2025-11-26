package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class SpenColorPickerLayout2 extends View {
    private static final String TAG = "settingui-colorPicker";
    private SPenImageUtil drawableImg;
    View mColorPickerColorImage;
    View mColorPickerCurrentColor;
    View mColorPickerHandle;
    View mColorPickerdExitBtn;
    private int mCurrentColor;
    private final SpenImageLoader mImageLoader;
    View.OnLayoutChangeListener mLayoutChangeListener;
    private RelativeLayout mParentRelativeLayout;
    View.OnTouchListener mSpoidExitListener;
    View.OnTouchListener mSpoidSettingListener;
    View mSpuitSettings;
    View mSpuitdBG;
    private final SPenTextUtil mStringUtil;
    private int mXDelta;
    private int mYDelta;

    public SpenColorPickerLayout2(Context context, RelativeLayout canvasLayout, float ratio, int x, int y) {
        super(context);
        this.mParentRelativeLayout = null;
        this.mCurrentColor = 0;
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenColorPickerLayout2.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenColorPickerLayout2.this.mSpuitSettings != null && SpenColorPickerLayout2.this.mSpuitSettings.getVisibility() != 8) {
                        int count = 0;
                        if (left != oldLeft) {
                            count = 0 + 1;
                        }
                        if (right != oldRight) {
                            count++;
                        }
                        if (top != oldTop) {
                            count++;
                        }
                        if (bottom != oldBottom) {
                            count++;
                        }
                        if (count == 1) {
                            SpenColorPickerLayout2.this.checkPosition();
                        }
                    }
                } catch (NullPointerException e) {
                }
            }
        };
        this.mSpoidSettingListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenColorPickerLayout2.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int x2 = (int) event.getRawX();
                int y2 = (int) event.getRawY();
                switch (event.getAction()) {
                    case 0:
                        RelativeLayout.LayoutParams spoidSettingParams = (RelativeLayout.LayoutParams) SpenColorPickerLayout2.this.mColorPickerHandle.getLayoutParams();
                        SpenColorPickerLayout2.this.mXDelta = x2 - spoidSettingParams.leftMargin;
                        SpenColorPickerLayout2.this.mYDelta = y2 - spoidSettingParams.topMargin;
                        break;
                    case 2:
                        RelativeLayout.LayoutParams spoidSettinghandleParams = (RelativeLayout.LayoutParams) SpenColorPickerLayout2.this.mColorPickerHandle.getLayoutParams();
                        RelativeLayout.LayoutParams spoidSettingBgParams = (RelativeLayout.LayoutParams) SpenColorPickerLayout2.this.mSpuitdBG.getLayoutParams();
                        RelativeLayout.LayoutParams spoidColorImageParams = (RelativeLayout.LayoutParams) SpenColorPickerLayout2.this.mColorPickerColorImage.getLayoutParams();
                        RelativeLayout.LayoutParams spoidExitBtnParams = (RelativeLayout.LayoutParams) SpenColorPickerLayout2.this.mColorPickerdExitBtn.getLayoutParams();
                        RelativeLayout.LayoutParams spuitCurrentColorParams = (RelativeLayout.LayoutParams) SpenColorPickerLayout2.this.mColorPickerCurrentColor.getLayoutParams();
                        spoidSettinghandleParams.leftMargin = x2 - SpenColorPickerLayout2.this.mXDelta;
                        spoidSettinghandleParams.topMargin = y2 - SpenColorPickerLayout2.this.mYDelta;
                        if (spoidSettinghandleParams.leftMargin < 0) {
                            spoidSettinghandleParams.leftMargin = 0;
                        }
                        if (spoidSettinghandleParams.topMargin < 0) {
                            spoidSettinghandleParams.topMargin = 0;
                        }
                        int minWidth = SpenColorPickerLayout2.this.drawableImg.getIntValueAppliedDensity(106.0f);
                        int minHeight = SpenColorPickerLayout2.this.drawableImg.getIntValueAppliedDensity(38.0f);
                        if (spoidSettinghandleParams.leftMargin > SpenColorPickerLayout2.this.mParentRelativeLayout.getWidth() - minWidth) {
                            spoidSettinghandleParams.leftMargin = SpenColorPickerLayout2.this.mParentRelativeLayout.getWidth() - minWidth;
                        }
                        if (spoidSettinghandleParams.topMargin > SpenColorPickerLayout2.this.mParentRelativeLayout.getHeight() - minHeight) {
                            spoidSettinghandleParams.topMargin = SpenColorPickerLayout2.this.mParentRelativeLayout.getHeight() - minHeight;
                        }
                        spoidSettingBgParams.leftMargin = spoidSettinghandleParams.leftMargin + SpenColorPickerLayout2.this.drawableImg.getIntValueAppliedDensity(22.0f);
                        spoidSettingBgParams.topMargin = spoidSettinghandleParams.topMargin + 0;
                        spoidColorImageParams.leftMargin = spoidSettinghandleParams.leftMargin + SpenColorPickerLayout2.this.drawableImg.getIntValueAppliedDensity(25.0f);
                        spoidColorImageParams.topMargin = spoidSettinghandleParams.topMargin + SpenColorPickerLayout2.this.drawableImg.getIntValueAppliedDensity(7.0f);
                        spuitCurrentColorParams.leftMargin = spoidSettinghandleParams.leftMargin + SpenColorPickerLayout2.this.drawableImg.getIntValueAppliedDensity(50.0f);
                        spuitCurrentColorParams.topMargin = spoidSettinghandleParams.topMargin + SpenColorPickerLayout2.this.drawableImg.getIntValueAppliedDensity(7.0f);
                        spoidExitBtnParams.leftMargin = spoidSettinghandleParams.leftMargin + SpenColorPickerLayout2.this.drawableImg.getIntValueAppliedDensity(78.0f);
                        spoidExitBtnParams.topMargin = spoidSettinghandleParams.topMargin;
                        SpenColorPickerLayout2.this.mColorPickerHandle.setLayoutParams(spoidSettinghandleParams);
                        SpenColorPickerLayout2.this.mSpuitdBG.setLayoutParams(spoidSettingBgParams);
                        SpenColorPickerLayout2.this.mColorPickerColorImage.setLayoutParams(spoidColorImageParams);
                        SpenColorPickerLayout2.this.mColorPickerCurrentColor.setLayoutParams(spuitCurrentColorParams);
                        SpenColorPickerLayout2.this.mColorPickerdExitBtn.setLayoutParams(spoidExitBtnParams);
                        break;
                }
                return true;
            }
        };
        this.mSpoidExitListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenColorPickerLayout2.3
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        SpenColorPickerLayout2.this.mColorPickerdExitBtn.setPressed(true);
                        return true;
                    case 1:
                        SpenColorPickerLayout2.this.mColorPickerdExitBtn.setPressed(false);
                        SpenColorPickerLayout2.this.mColorPickerdExitBtn.performClick();
                        return true;
                    case 2:
                    default:
                        return true;
                }
            }
        };
        this.mStringUtil = new SPenTextUtil(context);
        this.drawableImg = new SPenImageUtil(context, "", ratio);
        this.mImageLoader = new SpenImageLoader(this.drawableImg);
        this.mParentRelativeLayout = canvasLayout;
        initSpuitSetting(x, y);
    }

    protected void resetPositionWhenRotateSpuitOut(int mCanvasWidth, int mCanvasHeight) {
        if (this.mColorPickerHandle != null) {
            RelativeLayout.LayoutParams spoidSettinghandleParams = (RelativeLayout.LayoutParams) this.mColorPickerHandle.getLayoutParams();
            RelativeLayout.LayoutParams spoidSettingBgParams = (RelativeLayout.LayoutParams) this.mSpuitdBG.getLayoutParams();
            RelativeLayout.LayoutParams spoidColorImageParams = (RelativeLayout.LayoutParams) this.mColorPickerColorImage.getLayoutParams();
            RelativeLayout.LayoutParams spoidExitBtnParams = (RelativeLayout.LayoutParams) this.mColorPickerdExitBtn.getLayoutParams();
            RelativeLayout.LayoutParams spuitCurrentColorParams = (RelativeLayout.LayoutParams) this.mColorPickerCurrentColor.getLayoutParams();
            Rect oldParentRect = new Rect();
            Rect newParentRect = new Rect();
            this.mParentRelativeLayout.getGlobalVisibleRect(oldParentRect);
            if (oldParentRect.width() > oldParentRect.height()) {
                oldParentRect.bottom = mCanvasWidth;
                oldParentRect.right = mCanvasHeight;
            } else {
                oldParentRect.bottom = mCanvasHeight;
                oldParentRect.right = mCanvasWidth;
            }
            newParentRect.left = oldParentRect.left;
            newParentRect.top = oldParentRect.top;
            newParentRect.right = oldParentRect.bottom;
            newParentRect.bottom = oldParentRect.right;
            Rect rootRect = new Rect();
            this.mParentRelativeLayout.getRootView().getGlobalVisibleRect(rootRect);
            Display display = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
            Point p = new Point();
            display.getSize(p);
            Log.v(TAG, "==== colorPicker ====");
            Log.i(TAG, "old  = " + oldParentRect.left + ", " + oldParentRect.top + ", " + oldParentRect.right + ", " + oldParentRect.bottom);
            Log.e(TAG, "new  = " + newParentRect.left + ", " + newParentRect.top + ", " + newParentRect.right + ", " + newParentRect.bottom);
            Rect r = new Rect();
            r.left = oldParentRect.left + spoidSettinghandleParams.leftMargin;
            r.top = oldParentRect.top + spoidSettinghandleParams.topMargin;
            r.right = r.left + this.drawableImg.getIntValueAppliedDensity(106.0f);
            r.bottom = r.top + this.drawableImg.getIntValueAppliedDensity(38.0f);
            Log.d(TAG, "view = " + r.left + ", " + r.top + ", " + r.right + ", " + r.bottom);
            float left = r.left - oldParentRect.left;
            float right = oldParentRect.right - r.right;
            float top = r.top - oldParentRect.top;
            float bottom = oldParentRect.bottom - r.bottom;
            float hRatio = left / (left + right);
            float vRatio = top / (top + bottom);
            Log.w(TAG, "left :" + left + ", right :" + right);
            Log.w(TAG, "top :" + top + ", bottom :" + bottom);
            Log.v(TAG, "hRatio = " + hRatio + ", vRatio = " + vRatio);
            if (hRatio > 0.99d) {
                hRatio = 1.0f;
            } else if (hRatio < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                hRatio = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            }
            if (vRatio > 0.99d) {
                vRatio = 1.0f;
            } else if (vRatio < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                vRatio = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            }
            spoidSettinghandleParams.leftMargin = Math.round((newParentRect.width() - r.width()) * hRatio);
            spoidSettinghandleParams.topMargin = Math.round((newParentRect.height() - r.height()) * vRatio);
            Log.e(TAG, "lMargin = " + spoidSettinghandleParams.leftMargin + ", tMargin = " + spoidSettinghandleParams.topMargin);
            spoidSettingBgParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(22.0f);
            spoidSettingBgParams.topMargin = spoidSettinghandleParams.topMargin;
            spoidColorImageParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(25.0f);
            spoidColorImageParams.topMargin = spoidSettinghandleParams.topMargin + this.drawableImg.getIntValueAppliedDensity(7.0f);
            spuitCurrentColorParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(50.0f);
            spuitCurrentColorParams.topMargin = spoidSettinghandleParams.topMargin + this.drawableImg.getIntValueAppliedDensity(7.0f);
            spoidExitBtnParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(78.0f);
            spoidExitBtnParams.topMargin = spoidSettinghandleParams.topMargin;
            this.mColorPickerHandle.setLayoutParams(spoidSettinghandleParams);
            this.mSpuitdBG.setLayoutParams(spoidSettingBgParams);
            this.mColorPickerColorImage.setLayoutParams(spoidColorImageParams);
            this.mColorPickerCurrentColor.setLayoutParams(spuitCurrentColorParams);
            this.mColorPickerdExitBtn.setLayoutParams(spoidExitBtnParams);
        }
    }

    public void close() {
        this.drawableImg.unbindDrawables(this.mSpuitSettings);
        this.mSpuitSettings = null;
        this.drawableImg.unbindDrawables(this.mSpuitdBG);
        this.mSpuitdBG = null;
        this.drawableImg.unbindDrawables(this.mColorPickerHandle);
        this.mColorPickerHandle = null;
        this.drawableImg.unbindDrawables(this.mColorPickerdExitBtn);
        this.mColorPickerdExitBtn = null;
        this.drawableImg.unbindDrawables(this.mColorPickerColorImage);
        this.mColorPickerColorImage = null;
        this.drawableImg.unbindDrawables(this.mColorPickerCurrentColor);
        this.mColorPickerCurrentColor = null;
        this.mParentRelativeLayout = null;
        this.drawableImg.unbindDrawables(this);
        this.drawableImg = null;
    }

    private void setCanvasSize() {
        if (this.mSpuitSettings != null) {
            invalidate();
        }
    }

    public void setColorPickerColor(int color) {
        this.mCurrentColor = color;
        this.mColorPickerCurrentColor.setBackgroundColor(this.mCurrentColor);
        this.mColorPickerCurrentColor.setVisibility(0);
    }

    public void show() {
        if (!this.mImageLoader.mLoaded) {
            this.mImageLoader.loadImage();
        }
        this.mSpuitSettings.bringToFront();
        setCanvasSize();
        this.mSpuitSettings.setVisibility(0);
        checkPosition();
        this.mSpuitSettings.invalidate();
    }

    public void hide() {
        this.mSpuitSettings.setVisibility(8);
    }

    public int getColorPickerCurrentColor() {
        return this.mCurrentColor;
    }

    public int getColorPickerSettingVisible() {
        return this.mSpuitSettings.getVisibility();
    }

    private void initSpuitSetting(int x, int y) {
        this.mSpuitSettings = totalLayout();
        this.mSpuitSettings.setVisibility(8);
        this.mColorPickerHandle.setOnTouchListener(this.mSpoidSettingListener);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-2, -2);
        lp.setMargins(0, 0, 0, 0);
        try {
            if (this.mParentRelativeLayout != null) {
                this.mParentRelativeLayout.addView(this.mSpuitSettings, lp);
                this.mParentRelativeLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
            }
        } catch (IllegalArgumentException e) {
        }
        movePosition(x, y);
        setVisibility(8);
    }

    private View totalLayout() {
        LinearLayout totalLayout = new LinearLayout(getContext());
        totalLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        totalLayout.addView(bodyLayout());
        return totalLayout;
    }

    private ViewGroup bodyLayout() {
        RelativeLayout bodyLayout = new RelativeLayout(getContext());
        bodyLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.mSpuitdBG = spuitdBg();
        this.mColorPickerHandle = spuitdHandle();
        this.mColorPickerdExitBtn = spuitExitBtn();
        this.mColorPickerColorImage = spuitColorImage();
        this.mColorPickerCurrentColor = spuitCurrentColor();
        bodyLayout.addView(this.mColorPickerHandle);
        bodyLayout.addView(this.mSpuitdBG);
        bodyLayout.addView(this.mColorPickerdExitBtn);
        bodyLayout.addView(this.mColorPickerColorImage);
        bodyLayout.addView(this.mColorPickerCurrentColor);
        return bodyLayout;
    }

    private View spuitdBg() {
        ImageView spoidBgButton = new ImageView(getContext());
        RelativeLayout.LayoutParams spoidBgParams = new RelativeLayout.LayoutParams(this.drawableImg.getIntValueAppliedDensity(56.0f), this.drawableImg.getIntValueAppliedDensity(38.0f));
        spoidBgParams.alignWithParent = true;
        spoidBgParams.addRule(9);
        spoidBgParams.setMargins(this.drawableImg.getIntValueAppliedDensity(22.0f), 0, 0, 0);
        spoidBgButton.setFocusable(false);
        spoidBgButton.setClickable(true);
        spoidBgButton.setLayoutParams(spoidBgParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(spoidBgButton, "snote_toolbar_bg_center2_normal");
        return spoidBgButton;
    }

    private View spuitdHandle() {
        ImageView spoidHandle = new ImageView(getContext());
        RelativeLayout.LayoutParams spoidHandleParams = new RelativeLayout.LayoutParams(this.drawableImg.getIntValueAppliedDensity(22.0f), this.drawableImg.getIntValueAppliedDensity(38.0f));
        spoidHandleParams.alignWithParent = true;
        spoidHandleParams.addRule(9);
        spoidHandle.setLayoutParams(spoidHandleParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(spoidHandle, "snote_toolbar_handle", 22, 38);
        return spoidHandle;
    }

    private View spuitExitBtn() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams spuitExitLayoutParams = new RelativeLayout.LayoutParams(this.drawableImg.getIntValueAppliedDensity(28.0f), this.drawableImg.getIntValueAppliedDensity(38.0f));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(relativeLayout, "snote_toolbar_bg_right_normal", "snote_toolbar_bg_right_selectedl", "snote_toolbar_bg_right_focus", 28, 38);
        ImageButton exitButton = new ImageButton(getContext());
        this.mImageLoader.addViewBackgroundSelectableImageLoad(exitButton, "snote_popup_icon_close", "snote_popup_icon_close", "snote_popup_icon_close", 18, 18);
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(this.drawableImg.getIntValueAppliedDensity(22.0f), this.drawableImg.getIntValueAppliedDensity(22.0f));
        exitButtonParams.setMargins(this.drawableImg.getIntValueAppliedDensity(2.0f), this.drawableImg.getIntValueAppliedDensity(7.0f), 0, 0);
        exitButton.setLayoutParams(exitButtonParams);
        exitButton.setFocusable(true);
        exitButton.setContentDescription(this.mStringUtil.setString("string_close"));
        exitButton.setOnTouchListener(this.mSpoidExitListener);
        spuitExitLayoutParams.alignWithParent = true;
        spuitExitLayoutParams.addRule(9);
        spuitExitLayoutParams.setMargins(this.drawableImg.getIntValueAppliedDensity(78.0f), 0, 0, 0);
        relativeLayout.setLayoutParams(spuitExitLayoutParams);
        relativeLayout.setFocusable(true);
        relativeLayout.setContentDescription(this.mStringUtil.setString("string_close"));
        relativeLayout.addView(exitButton);
        return relativeLayout;
    }

    private View spuitColorImage() {
        ImageView mSpuitColorView = new ImageView(getContext());
        RelativeLayout.LayoutParams mSpoidColorViewParams = new RelativeLayout.LayoutParams(this.drawableImg.getIntValueAppliedDensity(22.0f), this.drawableImg.getIntValueAppliedDensity(22.0f));
        mSpoidColorViewParams.setMargins(this.drawableImg.getIntValueAppliedDensity(25.0f), this.drawableImg.getIntValueAppliedDensity(7.0f), 0, 0);
        mSpuitColorView.setLayoutParams(mSpoidColorViewParams);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(mSpuitColorView, "snote_toolbar_icon_spoid_hover", "snote_color_spoid_press", "snote_color_spoid_focus", 22, 22);
        return mSpuitColorView;
    }

    private View spuitCurrentColor() {
        ImageView mSpuitColorFirst = new ImageView(getContext());
        RelativeLayout.LayoutParams mSpuitColorFirstParams = new RelativeLayout.LayoutParams(this.drawableImg.getIntValueAppliedDensity(22.0f), this.drawableImg.getIntValueAppliedDensity(22.0f));
        mSpuitColorFirstParams.setMargins(this.drawableImg.getIntValueAppliedDensity(50.0f), this.drawableImg.getIntValueAppliedDensity(7.0f), 0, 0);
        mSpuitColorFirst.setLayoutParams(mSpuitColorFirstParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(mSpuitColorFirst, "snote_colorchip_shadow");
        LinearLayout mSpuitCurrentColor = new LinearLayout(getContext());
        mSpuitCurrentColor.setLayoutParams(mSpuitColorFirstParams);
        mSpuitCurrentColor.setBackgroundColor(-65536);
        mSpuitCurrentColor.addView(mSpuitColorFirst);
        return mSpuitCurrentColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPosition() {
        int[] location = new int[2];
        int[] parentLocation = new int[2];
        int minWidth = this.drawableImg.getIntValueAppliedDensity(106.0f);
        int minHeight = this.drawableImg.getIntValueAppliedDensity(38.0f);
        this.mColorPickerHandle.getLocationOnScreen(location);
        this.mParentRelativeLayout.getLocationOnScreen(parentLocation);
        Rect parentRect = new Rect(parentLocation[0], parentLocation[1], parentLocation[0] + this.mParentRelativeLayout.getWidth(), parentLocation[1] + this.mParentRelativeLayout.getHeight());
        RelativeLayout.LayoutParams spoidSettinghandleParams = (RelativeLayout.LayoutParams) this.mColorPickerHandle.getLayoutParams();
        RelativeLayout.LayoutParams spoidSettingBgParams = (RelativeLayout.LayoutParams) this.mSpuitdBG.getLayoutParams();
        RelativeLayout.LayoutParams spoidColorImageParams = (RelativeLayout.LayoutParams) this.mColorPickerColorImage.getLayoutParams();
        RelativeLayout.LayoutParams spoidExitBtnParams = (RelativeLayout.LayoutParams) this.mColorPickerdExitBtn.getLayoutParams();
        RelativeLayout.LayoutParams spuitCurrentColorParams = (RelativeLayout.LayoutParams) this.mColorPickerCurrentColor.getLayoutParams();
        if (location[0] < parentRect.left) {
            spoidSettinghandleParams.leftMargin = 0;
        }
        if (location[1] < parentRect.top) {
            spoidSettinghandleParams.topMargin = 0;
        }
        if (parentRect.right - location[0] < minWidth) {
            spoidSettinghandleParams.leftMargin = parentRect.width() - minWidth;
            if (spoidSettinghandleParams.leftMargin < 0) {
                spoidSettinghandleParams.leftMargin = 0;
            }
        }
        if (parentRect.bottom - location[1] < minHeight) {
            spoidSettinghandleParams.topMargin = parentRect.height() - minHeight;
            if (spoidSettinghandleParams.topMargin < 0) {
                spoidSettinghandleParams.topMargin = 0;
            }
        }
        spoidSettingBgParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(22.0f);
        spoidSettingBgParams.topMargin = spoidSettinghandleParams.topMargin;
        spoidColorImageParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(25.0f);
        spoidColorImageParams.topMargin = spoidSettinghandleParams.topMargin + this.drawableImg.getIntValueAppliedDensity(7.0f);
        spuitCurrentColorParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(50.0f);
        spuitCurrentColorParams.topMargin = spoidSettinghandleParams.topMargin + this.drawableImg.getIntValueAppliedDensity(7.0f);
        spoidExitBtnParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(78.0f);
        spoidExitBtnParams.topMargin = spoidSettinghandleParams.topMargin;
        this.mColorPickerHandle.setLayoutParams(spoidSettinghandleParams);
        this.mSpuitdBG.setLayoutParams(spoidSettingBgParams);
        this.mColorPickerColorImage.setLayoutParams(spoidColorImageParams);
        this.mColorPickerCurrentColor.setLayoutParams(spuitCurrentColorParams);
        this.mColorPickerdExitBtn.setLayoutParams(spoidExitBtnParams);
    }

    void movePosition(int x, int y) {
        if (this.mParentRelativeLayout != null) {
            RelativeLayout.LayoutParams spoidSettinghandleParams = (RelativeLayout.LayoutParams) this.mColorPickerHandle.getLayoutParams();
            RelativeLayout.LayoutParams spoidSettingBgParams = (RelativeLayout.LayoutParams) this.mSpuitdBG.getLayoutParams();
            RelativeLayout.LayoutParams spoidColorImageParams = (RelativeLayout.LayoutParams) this.mColorPickerColorImage.getLayoutParams();
            RelativeLayout.LayoutParams spoidExitBtnParams = (RelativeLayout.LayoutParams) this.mColorPickerdExitBtn.getLayoutParams();
            RelativeLayout.LayoutParams spuitCurrentColorParams = (RelativeLayout.LayoutParams) this.mColorPickerCurrentColor.getLayoutParams();
            spoidSettinghandleParams.leftMargin = x;
            spoidSettinghandleParams.topMargin = y;
            if (spoidSettinghandleParams.leftMargin < 0) {
                spoidSettinghandleParams.leftMargin = 0;
            }
            if (spoidSettinghandleParams.topMargin < 0) {
                spoidSettinghandleParams.topMargin = 0;
            }
            int minWidth = this.drawableImg.getIntValueAppliedDensity(106.0f);
            int minHeight = this.drawableImg.getIntValueAppliedDensity(38.0f);
            if (this.mParentRelativeLayout.getWidth() > 0 && spoidSettinghandleParams.leftMargin > this.mParentRelativeLayout.getWidth() - minWidth) {
                spoidSettinghandleParams.leftMargin = this.mParentRelativeLayout.getWidth() - minWidth;
            }
            if (this.mParentRelativeLayout.getHeight() > 0 && spoidSettinghandleParams.topMargin > this.mParentRelativeLayout.getHeight() - minHeight) {
                spoidSettinghandleParams.topMargin = this.mParentRelativeLayout.getHeight() - minHeight;
            }
            spoidSettingBgParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(22.0f);
            spoidSettingBgParams.topMargin = spoidSettinghandleParams.topMargin;
            spoidColorImageParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(25.0f);
            spoidColorImageParams.topMargin = spoidSettinghandleParams.topMargin + this.drawableImg.getIntValueAppliedDensity(7.0f);
            spuitCurrentColorParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(50.0f);
            spuitCurrentColorParams.topMargin = spoidSettinghandleParams.topMargin + this.drawableImg.getIntValueAppliedDensity(7.0f);
            spoidExitBtnParams.leftMargin = spoidSettinghandleParams.leftMargin + this.drawableImg.getIntValueAppliedDensity(78.0f);
            spoidExitBtnParams.topMargin = spoidSettinghandleParams.topMargin;
            this.mColorPickerHandle.setLayoutParams(spoidSettinghandleParams);
            this.mSpuitdBG.setLayoutParams(spoidSettingBgParams);
            this.mColorPickerColorImage.setLayoutParams(spoidColorImageParams);
            this.mColorPickerCurrentColor.setLayoutParams(spuitCurrentColorParams);
            this.mColorPickerdExitBtn.setLayoutParams(spoidExitBtnParams);
        }
    }
}
