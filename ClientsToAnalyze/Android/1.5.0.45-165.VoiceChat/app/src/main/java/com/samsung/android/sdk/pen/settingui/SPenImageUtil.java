package com.samsung.android.sdk.pen.settingui;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class SPenImageUtil {
    protected Resources mContextResources;
    protected String mCustom_imagepath;
    protected Context mDrawableContext;
    protected float mOnePT;
    protected Resources mSdkResources;
    protected int mSdkVersion = Build.VERSION.SDK_INT;

    public SPenImageUtil(Context paramContext, String customImagePath, float ratio) {
        this.mOnePT = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mCustom_imagepath = "";
        this.mSdkResources = null;
        this.mContextResources = null;
        this.mDrawableContext = paramContext;
        this.mCustom_imagepath = customImagePath;
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        this.mOnePT = localDisplayMetrics.density * ratio;
        try {
            PackageManager manager = this.mDrawableContext.getPackageManager();
            this.mSdkResources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            this.mContextResources = this.mDrawableContext.getResources();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Drawable setDrawableImg(String drawableName) throws Resources.NotFoundException, IOException {
        if (this.mCustom_imagepath.equals("spen_sdk_resource_custom")) {
            int mDrawableResID = this.mContextResources.getIdentifier(drawableName, "drawable", this.mDrawableContext.getPackageName());
            if (mDrawableResID == 0) {
                int mDrawableResID2 = this.mSdkResources.getIdentifier(drawableName, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
                if (mDrawableResID2 == 0) {
                    return null;
                }
                Drawable drawable = SpenScreenCodecDecoder.getDrawable(this.mSdkResources, mDrawableResID2);
                return drawable;
            }
            Drawable drawable2 = SpenScreenCodecDecoder.getDrawable(this.mContextResources, mDrawableResID);
            return drawable2;
        }
        int mDrawableResID3 = this.mSdkResources.getIdentifier(drawableName, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
        if (mDrawableResID3 == 0) {
            return null;
        }
        Drawable drawable3 = SpenScreenCodecDecoder.getDrawable(this.mSdkResources, mDrawableResID3);
        return drawable3;
    }

    protected Drawable setDrawableImg(String drawableName, int width, int height) throws Resources.NotFoundException, IOException {
        if (this.mCustom_imagepath.equals("spen_sdk_resource_custom")) {
            int mDrawableResID = this.mContextResources.getIdentifier(drawableName, "drawable", this.mDrawableContext.getPackageName());
            if (mDrawableResID == 0) {
                int mDrawableResID2 = this.mSdkResources.getIdentifier(drawableName, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
                if (mDrawableResID2 == 0) {
                    return null;
                }
                Drawable drawable = resizeImage(this.mSdkResources, mDrawableResID2, width, height);
                return drawable;
            }
            Drawable drawable2 = resizeImage(this.mContextResources, mDrawableResID, width, height);
            return drawable2;
        }
        int mDrawableResID3 = this.mSdkResources.getIdentifier(drawableName, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
        if (mDrawableResID3 == 0) {
            return null;
        }
        Drawable drawable3 = resizeImage(this.mSdkResources, mDrawableResID3, width, height);
        return drawable3;
    }

    public Drawable resizeImage(Resources resources, int resId, int iconWidth, int iconHeight) throws Resources.NotFoundException, IOException {
        InputStream stream = resources.openRawResource(resId);
        Bitmap BitmapOrg = SpenScreenCodecDecoder.decodeStream(stream);
        if (BitmapOrg == null) {
            return null;
        }
        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        int newWidth = getIntValueAppliedDensity(iconWidth);
        int newHeight = getIntValueAppliedDensity(iconHeight);
        float scaleWidth = newWidth / width;
        float scaleHeight = newHeight / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width, height, matrix, true);
        return new BitmapDrawable(resources, resizedBitmap);
    }

    protected StateListDrawable setDrawableSelectImg(String defaultImg, String pressedImg, String focusedImg) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (defaultImg != null) {
            localStateListDrawable.addState(new int[]{-16842919, -16842913, -16842908}, setDrawableImg(defaultImg));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_pressed}, setDrawableImg(pressedImg));
        }
        if (focusedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_focused}, setDrawableImg(focusedImg));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_selected}, setDrawableImg(pressedImg));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableSelectImg(String defaultImg, String pressedImg, String focusedImg, int width, int height) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (defaultImg != null) {
            localStateListDrawable.addState(new int[]{-16842919, -16842913, -16842908}, setDrawableImg(defaultImg, width, height));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_pressed}, setDrawableImg(pressedImg, width, height));
        }
        if (focusedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_focused}, setDrawableImg(focusedImg, width, height));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_selected}, setDrawableImg(pressedImg, width, height));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableSelectedFocusImg(String defaultImg, String pressedImg, String selectfocusedImg, String unselectfocusedImg) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (defaultImg != null) {
            localStateListDrawable.addState(new int[]{-16842919, -16842913, -16842908}, setDrawableImg(defaultImg));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_pressed}, setDrawableImg(pressedImg));
        }
        if (selectfocusedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_focused, R.attr.state_selected}, setDrawableImg(selectfocusedImg));
        }
        if (unselectfocusedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_focused, -16842913}, setDrawableImg(unselectfocusedImg));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_selected}, setDrawableImg(pressedImg));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableDimImg(String defaultImg, String pressedImg, String focusedImg, String dimImg, int width, int height) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (defaultImg != null) {
            localStateListDrawable.addState(new int[]{-16842919, -16842913, -16842908, R.attr.state_enabled}, setDrawableImg(defaultImg, width, height));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_pressed}, setDrawableImg(pressedImg, width, height));
        }
        if (focusedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_focused}, setDrawableImg(focusedImg, width, height));
        }
        if (dimImg != null) {
            localStateListDrawable.addState(new int[]{-16842910}, setDrawableImg(dimImg, width, height));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableCheckedImg(String checkFalseImg, String checkTrueImg) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (checkFalseImg != null) {
            localStateListDrawable.addState(new int[]{-16842912}, setDrawableImg(checkFalseImg));
        }
        if (checkTrueImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked}, setDrawableImg(checkTrueImg));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableCheckedImg(String checkFalseImg, String checkTrueImg, int width, int height) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (checkFalseImg != null) {
            localStateListDrawable.addState(new int[]{-16842912}, setDrawableImg(checkFalseImg, width, height));
        }
        if (checkTrueImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked}, setDrawableImg(checkTrueImg, width, height));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableCheckedImg(String checkFalseImg, String checkTrueImg, String focusCheckImg, String focusUncheckImg, int width, int height) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (checkTrueImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked, -16842908, R.attr.state_enabled}, setDrawableImg(checkTrueImg, width, height));
        }
        if (checkFalseImg != null) {
            localStateListDrawable.addState(new int[]{-16842912, -16842908, R.attr.state_enabled}, setDrawableImg(checkFalseImg, width, height));
        }
        if (focusCheckImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked, R.attr.state_focused, R.attr.state_enabled}, setDrawableImg(focusCheckImg, width, height));
        }
        if (focusUncheckImg != null) {
            localStateListDrawable.addState(new int[]{-16842912, R.attr.state_focused, R.attr.state_enabled}, setDrawableImg(focusUncheckImg, width, height));
        }
        if (checkFalseImg != null) {
            localStateListDrawable.addState(new int[]{-16842912, R.attr.state_enabled}, setDrawableImg(checkFalseImg, width, height));
        }
        if (checkTrueImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked, R.attr.state_enabled}, setDrawableImg(checkTrueImg, width, height));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableCheckedImg(String checkFalseImg, String checkTrueImg, String focusCheckImg, String focusUncheckImg, String pressCheckImg, String pressUncheckImg, int width, int height) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (checkTrueImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked, -16842908, -16842919, R.attr.state_enabled}, setDrawableImg(checkTrueImg, width, height));
        }
        if (checkFalseImg != null) {
            localStateListDrawable.addState(new int[]{-16842912, -16842908, -16842919, R.attr.state_enabled}, setDrawableImg(checkFalseImg, width, height));
        }
        if (focusCheckImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked, R.attr.state_focused, -16842919, R.attr.state_enabled}, setDrawableImg(focusCheckImg, width, height));
        }
        if (focusUncheckImg != null) {
            localStateListDrawable.addState(new int[]{-16842912, R.attr.state_focused, -16842919, R.attr.state_enabled}, setDrawableImg(focusUncheckImg, width, height));
        }
        if (pressCheckImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked, R.attr.state_pressed, R.attr.state_enabled}, setDrawableImg(pressCheckImg, width, height));
        }
        if (pressUncheckImg != null) {
            localStateListDrawable.addState(new int[]{-16842912, R.attr.state_pressed, R.attr.state_enabled}, setDrawableImg(pressUncheckImg, width, height));
        }
        if (checkFalseImg != null) {
            localStateListDrawable.addState(new int[]{-16842912, -16842919, R.attr.state_enabled}, setDrawableImg(checkFalseImg, width, height));
        }
        if (checkTrueImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_checked, -16842919, R.attr.state_enabled}, setDrawableImg(checkTrueImg, width, height));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableSelectImg(String defaultImg, String pressedImg, String focusedImg, String selectedImg) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (defaultImg != null) {
            int[] arrayOfInt4 = {-16842919, -16842913, -16842908};
            localStateListDrawable.addState(arrayOfInt4, setDrawableImg(defaultImg));
        }
        if (focusedImg != null) {
            int[] arrayOfInt1 = {R.attr.state_focused};
            localStateListDrawable.addState(arrayOfInt1, setDrawableImg(focusedImg));
        }
        if (pressedImg != null) {
            int[] arrayOfInt3 = {R.attr.state_pressed};
            localStateListDrawable.addState(arrayOfInt3, setDrawableImg(pressedImg));
        }
        if (selectedImg != null) {
            int[] arrayOfInt2 = {R.attr.state_selected};
            localStateListDrawable.addState(arrayOfInt2, setDrawableImg(selectedImg));
        }
        return localStateListDrawable;
    }

    protected StateListDrawable setDrawableSelectColor(int defaultColor, int selectedColor, int pressColor) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        int[] defaultState = {-16842919, -16842913};
        localStateListDrawable.addState(defaultState, new ColorDrawable(defaultColor));
        int[] selecteState = {R.attr.state_pressed};
        localStateListDrawable.addState(selecteState, new ColorDrawable(selectedColor));
        int[] pressState = {R.attr.state_selected};
        localStateListDrawable.addState(pressState, new ColorDrawable(pressColor));
        return localStateListDrawable;
    }

    protected int getIntValueAppliedDensity(float paramFloat) {
        return Math.round(this.mOnePT * paramFloat);
    }

    public void unbindDrawables(View root) {
        if (root != null) {
            if (this.mSdkVersion < 16) {
                root.setBackgroundDrawable(null);
            } else {
                root.setBackground(null);
            }
            if (root.getBackground() != null) {
                root.getBackground().setCallback(null);
            }
            if (root instanceof ViewGroup) {
                for (int i = 0; i < ((ViewGroup) root).getChildCount(); i++) {
                    unbindDrawables(((ViewGroup) root).getChildAt(i));
                }
                if (!(root instanceof AdapterView)) {
                    ((ViewGroup) root).removeAllViews();
                } else {
                    ((AdapterView) root).setAdapter(null);
                    root = null;
                }
            }
            if (root instanceof SeekBar) {
                ((SeekBar) root).setProgressDrawable(null);
            }
            if (root instanceof ImageView) {
                ((ImageView) root).setImageDrawable(null);
                ((ImageView) root).setImageBitmap(null);
            }
            if (root instanceof ImageButton) {
                ((ImageButton) root).setImageDrawable(null);
                ((ImageButton) root).setImageBitmap(null);
            }
            if (root != null) {
            }
        }
    }
}
