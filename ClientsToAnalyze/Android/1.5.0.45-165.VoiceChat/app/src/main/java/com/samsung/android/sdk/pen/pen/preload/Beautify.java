package com.samsung.android.sdk.pen.pen.preload;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import com.samsung.android.sdk.pen.util.SpenError;
import com.sec.spp.push.Config;
import java.io.File;
import java.util.ArrayList;

@SuppressLint({"SdCardPath"})
/* loaded from: classes.dex */
public class Beautify implements SpenPenInterface {
    private static final int BEAUTIFY_PARAMETER_CURSIVE = 2;
    private static final int BEAUTIFY_PARAMETER_DUMMY = 4;
    private static final int BEAUTIFY_PARAMETER_LINETYPE = 1;
    private static final int BEAUTIFY_PARAMETER_MODULATION = 6;
    private static final int BEAUTIFY_PARAMETER_SCRATCH = 7;
    private static final int BEAUTIFY_PARAMETER_SLANT = 9;
    private static final int BEAUTIFY_PARAMETER_SLANTINDEX = 8;
    private static final int BEAUTIFY_PARAMETER_STYLEID = 0;
    private static final int BEAUTIFY_PARAMETER_SUSTENANCE = 3;
    private static final int BEAUTIFY_PARAMETER_THICKNESS = 5;
    private static final int BEAUTIFY_STYLEID_CURSIVE_LM = 11;
    private static final int BEAUTIFY_STYLEID_HUAI = 12;
    private static final int BEAUTIFY_STYLEID_HUANG = 5;
    private static final int BEAUTIFY_STYLEID_HUI = 6;
    private static final int BEAUTIFY_STYLEID_RUNNING_HAND_S = 1;
    private static final int BEAUTIFY_STYLEID_WANG = 3;
    private static final int[][] DEFAULT_SETTING_VALUES = {new int[]{11, 2, 5, 8, 1, 15, 70, 11, 0, 1}, new int[]{12, 2, 5, 1, 1, 18, 70, 13, 0, 1}, new int[]{5, 2, 2, 2, 1, 18, 70, 5, 0, 1}, new int[]{6, 2, 3, 3, 1, 12, 70, 6, 0, 1}, new int[]{1, 2, 2, 8, 1, 15, 70, 3, 0, 1}, new int[]{3, 1, 3, 5, 1, 12, 70, 1, 0, 1}};
    private static final int MAX_PARAMETER_INDEX = 10;
    private static final int MAX_STYLEID_COUNT = 6;
    public static final String TAG = "Beautify";
    private static float mDensity = 0.0f;
    private static final String mImagePath_eraser_bar = "eraser_bar";
    private static final String mImagePath_eraser_handel = "eraser_handel";
    private static final String mImagePath_eraser_handel_press = "eraser_handel_press";
    private static final String mImagePath_snote_option_in_bg = "snote_option_in_bg";
    private Bitmap mBitmap;
    private ArrayList<ImageButton> mButtonList;
    private Context mContext;
    private int mCurrentButtonIndex;
    private SeekBar mCursiveSeekBar;
    private SeekBar mDummySeekBar;
    private SeekBar mModulationSeekBar;
    private View mResetButton;
    private SpenPenInterface.ChangeListener mSettingListener;
    private SeekBar mSustenanceSeekBar;
    private final int nativeBeautify;
    private LinearLayout mAdvancedSettingLayout = null;
    private final int[][] mSettingValues = (int[][]) DEFAULT_SETTING_VALUES.clone();
    private final View.OnClickListener mResetButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.pen.preload.Beautify.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (Beautify.this.mSettingListener != null) {
                StringBuffer s = new StringBuffer();
                for (int settingIndex = 0; settingIndex < 10; settingIndex++) {
                    int settingValue = Beautify.DEFAULT_SETTING_VALUES[Beautify.this.mCurrentButtonIndex][settingIndex];
                    switch (settingIndex) {
                        case 0:
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][0] = settingValue;
                            break;
                        case 1:
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][1] = settingValue;
                            break;
                        case 2:
                            Beautify.this.mCursiveSeekBar.setProgress(settingValue);
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][2] = settingValue;
                            break;
                        case 3:
                            Beautify.this.mSustenanceSeekBar.setProgress(settingValue);
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][3] = settingValue;
                            break;
                        case 4:
                            Beautify.this.mDummySeekBar.setProgress(settingValue);
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][4] = settingValue;
                            break;
                        case 5:
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][5] = settingValue;
                            break;
                        case 6:
                            Beautify.this.mModulationSeekBar.setProgress(settingValue);
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][6] = settingValue;
                            break;
                        case 7:
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][7] = settingValue;
                            break;
                        case 8:
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][8] = settingValue;
                            break;
                        case 9:
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][9] = settingValue;
                            break;
                    }
                    s.append(settingValue);
                    s.append(';');
                }
                Beautify.this.setAdvancedSetting(s.toString());
                Beautify.this.mSettingListener.onChanged(s.toString());
            }
        }
    };
    private final SeekBar.OnSeekBarChangeListener mSeekBarListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.pen.preload.Beautify.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int settingValue;
            if (Beautify.this.mSettingListener != null) {
                StringBuffer s = new StringBuffer();
                for (int settingIndex = 0; settingIndex < 10; settingIndex++) {
                    switch (settingIndex) {
                        case 2:
                            settingValue = Beautify.this.mCursiveSeekBar.getProgress();
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][2] = settingValue;
                            break;
                        case 3:
                            settingValue = Beautify.this.mSustenanceSeekBar.getProgress();
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][3] = settingValue;
                            break;
                        case 4:
                            settingValue = Beautify.this.mDummySeekBar.getProgress();
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][4] = settingValue;
                            break;
                        case 5:
                        default:
                            settingValue = -1;
                            break;
                        case 6:
                            settingValue = Beautify.this.mModulationSeekBar.getProgress();
                            Beautify.this.mSettingValues[Beautify.this.mCurrentButtonIndex][6] = settingValue;
                            break;
                    }
                    s.append(settingValue);
                    s.append(';');
                }
                Beautify.this.setAdvancedSetting(s.toString());
                Beautify.this.mSettingListener.onChanged(s.toString());
            }
        }
    };

    private static native ArrayList<Object> native_command(int i, int i2, ArrayList<Object> arrayList);

    private static native boolean native_construct(int i);

    private static native boolean native_draw(int i, MotionEvent motionEvent, RectF rectF, int i2);

    private static native boolean native_end(int i, MotionEvent motionEvent, RectF rectF, int i2);

    private static native void native_finalize(int i);

    private static native String native_getAdvancedSetting(int i);

    private static native int native_getColor(int i);

    private static native float native_getMaxSettingValue(int i);

    private static native float native_getMinSettingValue(int i);

    private static native boolean native_getPenAttribute(int i, int i2);

    private static native boolean native_getProperty(int i, Bundle bundle);

    private static native float native_getSize(int i);

    private static native RectF native_getStrokeRect(int i, PointF[] pointFArr, float[] fArr, int[] iArr, float f, boolean z, String str);

    private static native int native_init();

    private static native boolean native_isCurveEnabled(int i);

    private static native boolean native_move(int i, MotionEvent motionEvent, RectF rectF, int i2);

    private static native void native_onLoad(int i);

    private static native void native_onUnload(int i);

    private static native boolean native_redraw(int i, MotionEvent motionEvent, RectF rectF, int i2);

    private static native boolean native_setAdvancedSetting(int i, String str);

    private static native boolean native_setBitmap(int i, Bitmap bitmap);

    private static native boolean native_setColor(int i, int i2);

    private static native boolean native_setCurveEnabled(int i, boolean z);

    private static native boolean native_setProperty(int i, Bundle bundle);

    private static native boolean native_setReferenceBitmap(int i, Bitmap bitmap);

    private static native boolean native_setSize(int i, float f);

    private static native boolean native_start(int i, MotionEvent motionEvent, RectF rectF, int i2);

    public Beautify() {
        IllegalStateException illegalStateException;
        File libFilePath = new File("/data/data/com.samsung.android.sdk.spen30/lib/libSPenBeautify.so");
        if (libFilePath.exists()) {
            try {
                System.load("/data/data/com.samsung.android.sdk.spen30/lib/libSPenBeautify.so");
            } finally {
                try {
                } catch (Exception e) {
                }
            }
        } else {
            try {
                System.loadLibrary("SPenBeautify");
            } catch (Exception e2) {
                throw new IllegalStateException("Beautify library is not initialized.");
            }
        }
        this.nativeBeautify = native_init();
    }

    public void construct() {
        native_construct(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) {
        native_onLoad(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public String getPrivateKeyHint() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(String key) {
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
        this.mContext = null;
        this.mBitmap = null;
        native_onUnload(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(Bundle propertyMap) {
        native_setProperty(this.nativeBeautify, propertyMap);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(Bundle propertyMap) {
        native_getProperty(this.nativeBeautify, propertyMap);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    public int getNativeHandle() {
        return this.nativeBeautify;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void draw(MotionEvent event, RectF rect) {
        if (this.mBitmap != null) {
            if (this.mBitmap.isRecycled()) {
                this.mBitmap = null;
                return;
            }
            this.mBitmap.setPixel(0, 0, 0);
            if (!native_draw(this.nativeBeautify, event, rect, event.getToolType(0))) {
                SpenError.ThrowUncheckedException(SpenError.getError(), toString());
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void redrawPen(MotionEvent allEvent, RectF rect) {
        if (this.mBitmap != null) {
            if (this.mBitmap.isRecycled()) {
                this.mBitmap = null;
                return;
            }
            this.mBitmap.setPixel(0, 0, 0);
            if (!native_redraw(this.nativeBeautify, allEvent, rect, allEvent.getToolType(0))) {
                SpenError.ThrowUncheckedException(SpenError.getError(), toString());
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        if (this.mBitmap != null && !native_setBitmap(this.nativeBeautify, this.mBitmap)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setReferenceBitmap(Bitmap bitmap) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setSize(float size) {
        if (!native_setSize(this.nativeBeautify, size)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getSize() {
        return native_getSize(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getMinSettingValue() {
        return native_getMinSettingValue(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getMaxSettingValue() {
        return native_getMaxSettingValue(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setColor(int color) {
        if (!native_setColor(this.nativeBeautify, color)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public int getColor() {
        return native_getColor(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setCurveEnabled(boolean curve) {
        if (!native_setCurveEnabled(this.nativeBeautify, curve)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean isCurveEnabled() {
        return native_isCurveEnabled(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void showAdvancedSetting(Context context, SpenPenInterface.ChangeListener listener, ViewGroup parentView) {
        if (this.mAdvancedSettingLayout == null) {
            this.mContext = context;
            DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
            mDensity = localDisplayMetrics.density;
            this.mAdvancedSettingLayout = initView();
            parentView.addView(this.mAdvancedSettingLayout);
            parentView.bringChildToFront(this.mAdvancedSettingLayout);
            this.mAdvancedSettingLayout.setVisibility(0);
            setListener();
            this.mSettingListener = listener;
            this.mCurrentButtonIndex = 0;
            setBeautifyType(this.mCurrentButtonIndex);
            return;
        }
        parentView.bringChildToFront(this.mAdvancedSettingLayout);
        this.mAdvancedSettingLayout.setVisibility(0);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void hideAdvancedSetting() {
        if (this.mAdvancedSettingLayout != null && this.mAdvancedSettingLayout.isShown()) {
            this.mAdvancedSettingLayout.setVisibility(8);
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setAdvancedSetting(String advancedSetting) {
        if (advancedSetting != null && !advancedSetting.isEmpty()) {
            String[] s = advancedSetting.split(Config.KEYVALUE_SPLIT);
            if (s.length != 0 && !native_setAdvancedSetting(this.nativeBeautify, advancedSetting)) {
                SpenError.ThrowUncheckedException(SpenError.getError(), toString());
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public String getAdvancedSetting() {
        return native_getAdvancedSetting(this.nativeBeautify);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public RectF getStrokeRect(PointF[] points, float[] pressures, int[] timestamps, float size, boolean isCurvable, String advanced) {
        return native_getStrokeRect(this.nativeBeautify, points, pressures, timestamps, size, isCurvable, advanced);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean getPenAttribute(int attribute) {
        return native_getPenAttribute(this.nativeBeautify, attribute);
    }

    private LinearLayout initView() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(-2, calculatePixel(345.0f));
        linearLayout.setLayoutParams(layoutParam);
        linearLayout.setBackgroundColor(-9868951);
        linearLayout.setX(calculatePixel(40.0f));
        linearLayout.setY(calculatePixel(135.0f));
        linearLayout.setOrientation(1);
        linearLayout.addView(beautifyTypeLayout());
        linearLayout.addView(cursiveLayout());
        linearLayout.addView(sustenanceLayout());
        linearLayout.addView(dummyLayout());
        linearLayout.addView(modulationLayout());
        linearLayout.addView(resetButtonLayout());
        return linearLayout;
    }

    private LinearLayout beautifyTypeLayout() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setLayoutParams(layoutParam);
        this.mButtonList = new ArrayList<>();
        for (int index = 0; index < 6; index++) {
            ImageButton button = new ImageButton(this.mContext);
            int imageNameIndex = index + 1;
            String imageName = "chinabrush_mode_0" + imageNameIndex;
            button.setImageDrawable(setDrawableImg(imageName));
            LinearLayout.LayoutParams buttonLayoutParam = new LinearLayout.LayoutParams(calculatePixel(30.0f), calculatePixel(30.0f));
            button.setLayoutParams(buttonLayoutParam);
            button.setBackgroundDrawable(setDrawableSelectImg("chinabrush_effect_btn_normal", "chinabrush_effect_btn_press", "chinabrush_effect_btn_press"));
            button.setFocusable(false);
            this.mButtonList.add(button);
            linearLayout.addView(button);
        }
        return linearLayout;
    }

    private View cursiveLayout() {
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = calculatePixel(5.0f);
        localLinearLayout.setLayoutParams(localLayoutParams);
        localLinearLayout.setOrientation(0);
        localLinearLayout.addView(cursiveSeekbar());
        TextView textView = new TextView(this.mContext);
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        textView.setLayoutParams(textLayoutParams);
        textView.setTextSize(12.0f);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setText("cursive");
        textView.setFocusable(false);
        textView.setPadding(0, calculatePixel(4.5f), 0, 0);
        localLinearLayout.addView(textView);
        return localLinearLayout;
    }

    private SeekBar cursiveSeekbar() throws PackageManager.NameNotFoundException {
        int insetMargin;
        SeekBar localSeekBar = new SeekBar(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(calculatePixel(110.0f), -2);
        localSeekBar.setLayoutParams(localLayoutParams);
        localSeekBar.setMax(12);
        localSeekBar.setThumb(setDrawableSelectImg(mImagePath_eraser_handel, mImagePath_eraser_handel_press, null));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(calculatePixel(5.0f));
        ClipDrawable localClipDrawable = new ClipDrawable(localGradientDrawable, 3, 1);
        Drawable localDrawable = setDrawableImg(mImagePath_eraser_bar);
        int targetSdkVersion = this.mContext.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 14) {
            if (targetSdkVersion <= 10) {
                if (this.mContext.getResources().getDisplayMetrics().densityDpi == 160) {
                    insetMargin = calculatePixel(6.5f);
                } else {
                    insetMargin = calculatePixel(5.5f);
                }
            } else if (this.mContext.getResources().getDisplayMetrics().densityDpi == 160) {
                insetMargin = calculatePixel(3.5f);
            } else {
                insetMargin = calculatePixel(2.5f);
            }
        } else {
            insetMargin = calculatePixel(2.0f);
        }
        InsetDrawable localInsetDrawable = new InsetDrawable(localDrawable, 0, insetMargin, 0, insetMargin);
        Drawable[] arrayOfDrawable = {localInsetDrawable, localClipDrawable};
        localSeekBar.setProgressDrawable(new LayerDrawable(arrayOfDrawable));
        this.mCursiveSeekBar = localSeekBar;
        return localSeekBar;
    }

    private View sustenanceLayout() {
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = calculatePixel(5.0f);
        localLinearLayout.setLayoutParams(localLayoutParams);
        localLinearLayout.setOrientation(0);
        localLinearLayout.addView(sustenanceSeekbar());
        TextView textView = new TextView(this.mContext);
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        textView.setLayoutParams(textLayoutParams);
        textView.setTextSize(12.0f);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setText("sustenance");
        textView.setFocusable(false);
        textView.setPadding(0, calculatePixel(4.5f), 0, 0);
        localLinearLayout.addView(textView);
        return localLinearLayout;
    }

    private SeekBar sustenanceSeekbar() throws PackageManager.NameNotFoundException {
        int insetMargin;
        SeekBar localSeekBar = new SeekBar(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(calculatePixel(110.0f), -2);
        localSeekBar.setLayoutParams(localLayoutParams);
        localSeekBar.setMax(16);
        localSeekBar.setThumb(setDrawableSelectImg(mImagePath_eraser_handel, mImagePath_eraser_handel_press, null));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(calculatePixel(5.0f));
        ClipDrawable localClipDrawable = new ClipDrawable(localGradientDrawable, 3, 1);
        Drawable localDrawable = setDrawableImg(mImagePath_eraser_bar);
        int targetSdkVersion = this.mContext.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 14) {
            if (targetSdkVersion <= 10) {
                if (this.mContext.getResources().getDisplayMetrics().densityDpi == 160) {
                    insetMargin = calculatePixel(6.5f);
                } else {
                    insetMargin = calculatePixel(5.5f);
                }
            } else if (this.mContext.getResources().getDisplayMetrics().densityDpi == 160) {
                insetMargin = calculatePixel(3.5f);
            } else {
                insetMargin = calculatePixel(2.5f);
            }
        } else {
            insetMargin = calculatePixel(2.0f);
        }
        InsetDrawable localInsetDrawable = new InsetDrawable(localDrawable, 0, insetMargin, 0, insetMargin);
        Drawable[] arrayOfDrawable = {localInsetDrawable, localClipDrawable};
        localSeekBar.setProgressDrawable(new LayerDrawable(arrayOfDrawable));
        this.mSustenanceSeekBar = localSeekBar;
        return localSeekBar;
    }

    private View dummyLayout() {
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = calculatePixel(5.0f);
        localLinearLayout.setLayoutParams(localLayoutParams);
        localLinearLayout.setOrientation(0);
        localLinearLayout.addView(dummySeekbar());
        TextView textView = new TextView(this.mContext);
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        textView.setLayoutParams(textLayoutParams);
        textView.setTextSize(12.0f);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setText("dummy");
        textView.setFocusable(false);
        textView.setPadding(0, calculatePixel(4.5f), 0, 0);
        localLinearLayout.addView(textView);
        return localLinearLayout;
    }

    private SeekBar dummySeekbar() throws PackageManager.NameNotFoundException {
        int insetMargin;
        SeekBar localSeekBar = new SeekBar(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(calculatePixel(110.0f), -2);
        localSeekBar.setLayoutParams(localLayoutParams);
        localSeekBar.setMax(20);
        localSeekBar.setThumb(setDrawableSelectImg(mImagePath_eraser_handel, mImagePath_eraser_handel_press, null));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(calculatePixel(5.0f));
        ClipDrawable localClipDrawable = new ClipDrawable(localGradientDrawable, 3, 1);
        Drawable localDrawable = setDrawableImg(mImagePath_eraser_bar);
        int targetSdkVersion = this.mContext.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 14) {
            if (targetSdkVersion <= 10) {
                if (this.mContext.getResources().getDisplayMetrics().densityDpi == 160) {
                    insetMargin = calculatePixel(6.5f);
                } else {
                    insetMargin = calculatePixel(5.5f);
                }
            } else if (this.mContext.getResources().getDisplayMetrics().densityDpi == 160) {
                insetMargin = calculatePixel(3.5f);
            } else {
                insetMargin = calculatePixel(2.5f);
            }
        } else {
            insetMargin = calculatePixel(2.0f);
        }
        InsetDrawable localInsetDrawable = new InsetDrawable(localDrawable, 0, insetMargin, 0, insetMargin);
        Drawable[] arrayOfDrawable = {localInsetDrawable, localClipDrawable};
        localSeekBar.setProgressDrawable(new LayerDrawable(arrayOfDrawable));
        this.mDummySeekBar = localSeekBar;
        return localSeekBar;
    }

    private View modulationLayout() {
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = calculatePixel(5.0f);
        localLinearLayout.setLayoutParams(localLayoutParams);
        localLinearLayout.setOrientation(0);
        localLinearLayout.addView(modulationSeekbar());
        TextView textView = new TextView(this.mContext);
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        textView.setLayoutParams(textLayoutParams);
        textView.setTextSize(12.0f);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setText("modulation");
        textView.setFocusable(false);
        textView.setPadding(0, calculatePixel(4.5f), 0, 0);
        localLinearLayout.addView(textView);
        return localLinearLayout;
    }

    private SeekBar modulationSeekbar() throws PackageManager.NameNotFoundException {
        int insetMargin;
        SeekBar localSeekBar = new SeekBar(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(calculatePixel(110.0f), -2);
        localSeekBar.setLayoutParams(localLayoutParams);
        localSeekBar.setMax(100);
        localSeekBar.setThumb(setDrawableSelectImg(mImagePath_eraser_handel, mImagePath_eraser_handel_press, null));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(calculatePixel(5.0f));
        ClipDrawable localClipDrawable = new ClipDrawable(localGradientDrawable, 3, 1);
        Drawable localDrawable = setDrawableImg(mImagePath_eraser_bar);
        int targetSdkVersion = this.mContext.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 14) {
            if (targetSdkVersion <= 10) {
                if (this.mContext.getResources().getDisplayMetrics().densityDpi == 160) {
                    insetMargin = calculatePixel(6.5f);
                } else {
                    insetMargin = calculatePixel(5.5f);
                }
            } else if (this.mContext.getResources().getDisplayMetrics().densityDpi == 160) {
                insetMargin = calculatePixel(3.5f);
            } else {
                insetMargin = calculatePixel(2.5f);
            }
        } else {
            insetMargin = calculatePixel(2.0f);
        }
        InsetDrawable localInsetDrawable = new InsetDrawable(localDrawable, 0, insetMargin, 0, insetMargin);
        Drawable[] arrayOfDrawable = {localInsetDrawable, localClipDrawable};
        localSeekBar.setProgressDrawable(new LayerDrawable(arrayOfDrawable));
        this.mModulationSeekBar = localSeekBar;
        return localSeekBar;
    }

    private View resetButtonLayout() {
        Button button = new Button(this.mContext);
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(-2, calculatePixel(40.0f));
        buttonLayoutParams.gravity = 17;
        buttonLayoutParams.topMargin = calculatePixel(5.0f);
        buttonLayoutParams.bottomMargin = calculatePixel(5.0f);
        button.setLayoutParams(buttonLayoutParams);
        button.setText("reset");
        this.mResetButton = button;
        return button;
    }

    private void setListener() {
        for (int index = 0; index < 6; index++) {
            this.mButtonList.get(index).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.pen.preload.Beautify.3
                @Override // android.view.View.OnClickListener
                public void onClick(View buttonView) {
                    for (int viewIndex = 0; viewIndex < 6; viewIndex++) {
                        if (buttonView.equals(Beautify.this.mButtonList.get(viewIndex))) {
                            if (Beautify.this.mCurrentButtonIndex == viewIndex && ((ImageButton) Beautify.this.mButtonList.get(Beautify.this.mCurrentButtonIndex)).isSelected()) {
                                Beautify.this.mCursiveSeekBar.setProgress(0);
                                Beautify.this.mSustenanceSeekBar.setProgress(0);
                                Beautify.this.mDummySeekBar.setProgress(0);
                                Beautify.this.mModulationSeekBar.setProgress(0);
                                ((ImageButton) Beautify.this.mButtonList.get(Beautify.this.mCurrentButtonIndex)).setSelected(false);
                                return;
                            }
                            Beautify.this.setBeautifyType(viewIndex);
                        }
                    }
                }
            });
        }
        if (this.mCursiveSeekBar != null) {
            this.mCursiveSeekBar.setOnSeekBarChangeListener(this.mSeekBarListner);
        }
        if (this.mSustenanceSeekBar != null) {
            this.mSustenanceSeekBar.setOnSeekBarChangeListener(this.mSeekBarListner);
        }
        if (this.mDummySeekBar != null) {
            this.mDummySeekBar.setOnSeekBarChangeListener(this.mSeekBarListner);
        }
        if (this.mModulationSeekBar != null) {
            this.mModulationSeekBar.setOnSeekBarChangeListener(this.mSeekBarListner);
        }
        if (this.mResetButton != null) {
            this.mResetButton.setOnClickListener(this.mResetButtonListener);
        }
    }

    private int calculatePixel(float paramFloat) {
        return (int) (mDensity * paramFloat);
    }

    private StateListDrawable setDrawableSelectImg(String defaultImg, String pressedImg, String selectedImg) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (defaultImg != null) {
            localStateListDrawable.addState(new int[]{-16842919, -16842913}, setDrawableImg(defaultImg));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_pressed}, setDrawableImg(pressedImg));
        }
        if (selectedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_selected}, setDrawableImg(selectedImg));
        }
        return localStateListDrawable;
    }

    protected Drawable setDrawableImg(String paramString) throws PackageManager.NameNotFoundException {
        PackageManager manager = this.mContext.getPackageManager();
        try {
            Resources mApk1Resources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            int mDrawableResID = mApk1Resources.getIdentifier(paramString, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            return mApk1Resources.getDrawable(mDrawableResID);
        } catch (PackageManager.NameNotFoundException e) {
            Log.i("TAG", "Resource loading is Failed");
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautifyType(int buttonIndex) {
        if (this.mSettingListener != null) {
            this.mCurrentButtonIndex = buttonIndex;
            StringBuffer s = new StringBuffer();
            for (int settingIndex = 0; settingIndex < 10; settingIndex++) {
                int settingValue = this.mSettingValues[buttonIndex][settingIndex];
                switch (settingIndex) {
                    case 2:
                        this.mCursiveSeekBar.setProgress(settingValue);
                        break;
                    case 3:
                        this.mSustenanceSeekBar.setProgress(settingValue);
                        break;
                    case 4:
                        this.mDummySeekBar.setProgress(settingValue);
                        break;
                    case 6:
                        this.mModulationSeekBar.setProgress(settingValue);
                        break;
                }
                s.append(settingValue);
                s.append(';');
            }
            setAdvancedSetting(s.toString());
            this.mSettingListener.onChanged(s.toString());
            for (int index = 0; index < 6; index++) {
                if (buttonIndex == index) {
                    this.mButtonList.get(index).setSelected(true);
                } else {
                    this.mButtonList.get(index).setSelected(false);
                }
            }
        }
    }
}
