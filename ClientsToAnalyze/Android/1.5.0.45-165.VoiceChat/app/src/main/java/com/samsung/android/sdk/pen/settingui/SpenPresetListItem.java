package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
class SpenPresetListItem extends SPenImageUtil {
    public static final int IB_PEN_PRESET_DELETE_ID = 12070502;
    public static final int IB_PEN_PRESET_PREVIEW_ID = 12070501;
    public static final int IV_PEN_PRESET_ALPHA_PREVIEW_ID = 12070701;
    public static final int IV_PEN_PRESET_PREVIEW_ID = 12070601;
    private static final String mImagePath_pen_preset_bg = "pen_preset_bg";
    private static final String mImagePath_pen_preset_bg_focus = "pen_preset_bg_focus";
    private static final String mImagePath_pen_preset_bg_press = "pen_preset_bg_press";
    private static final String mImagePath_progress_bg_alpha = "preview_alpha";
    private static final String mImagePath_snote_delete = "pen_preset_delete_normal";
    private static final String mImagePath_snote_delete_focus = "pen_preset_delete_focus";
    private static final String mImagePath_snote_delete_press = "pen_preset_delete_press";
    private final View mPresetListItemView;
    private final int mSdkVersion;

    public SpenPresetListItem(Context paramContext, String custom_imagepath, float ratio) {
        super(paramContext, custom_imagepath, ratio);
        this.mSdkVersion = Build.VERSION.SDK_INT;
        this.mPresetListItemView = PresetListItemView(this.mDrawableContext);
    }

    private View PresetListItemView(Context paramContext) {
        float preSetHeight = getIntValueAppliedDensity(65.0f);
        float deleteSize = getIntValueAppliedDensity(23.0f);
        RelativeLayout relativeLayout = new RelativeLayout(paramContext);
        AbsListView.LayoutParams localRelativeLayoutParam = new AbsListView.LayoutParams(getIntValueAppliedDensity(69.0f), getIntValueAppliedDensity(74.0f));
        relativeLayout.setLayoutParams(localRelativeLayoutParam);
        relativeLayout.setPadding(0, 0, 0, 0);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(16);
        RelativeLayout penAlphaPreview = new RelativeLayout(paramContext);
        RelativeLayout.LayoutParams penPreviewLayoutParams02 = new RelativeLayout.LayoutParams(getIntValueAppliedDensity(30.0f), getIntValueAppliedDensity(10.0f));
        penPreviewLayoutParams02.leftMargin = getIntValueAppliedDensity(20.0f);
        penPreviewLayoutParams02.topMargin = getIntValueAppliedDensity(35.0f);
        penAlphaPreview.setPadding(0, 0, 0, 0);
        penAlphaPreview.setLayoutParams(penPreviewLayoutParams02);
        if (this.mSdkVersion < 16) {
            penAlphaPreview.setBackgroundDrawable(setDrawableImg(mImagePath_progress_bg_alpha));
        } else {
            penAlphaPreview.setBackground(setDrawableImg(mImagePath_progress_bg_alpha));
        }
        penAlphaPreview.setVisibility(8);
        penAlphaPreview.setId(12070701);
        ImageButton previewButton = new ImageButton(paramContext);
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(getIntValueAppliedDensity(65.0f), getIntValueAppliedDensity(65.0f));
        previewButton.setBackgroundColor(0);
        previewButton.setPadding(0, 0, 0, 0);
        previewButton.setLayoutParams(localLayoutParams1);
        previewButton.setMaxHeight((int) preSetHeight);
        previewButton.setClickable(true);
        previewButton.setFocusable(true);
        previewButton.setId(12070501);
        ImageView previewImage = new ImageView(paramContext);
        previewImage.setLayoutParams(new RelativeLayout.LayoutParams(getIntValueAppliedDensity(65.0f), getIntValueAppliedDensity(65.0f)));
        previewImage.setId(12070601);
        ImageView presetBg = new ImageView(paramContext);
        presetBg.setLayoutParams(new RelativeLayout.LayoutParams(getIntValueAppliedDensity(65.0f), getIntValueAppliedDensity(65.0f)));
        ImageButton deleteButton = new ImageButton(paramContext);
        RelativeLayout.LayoutParams deleteButtonParams = new RelativeLayout.LayoutParams((int) deleteSize, (int) deleteSize);
        deleteButtonParams.topMargin = getIntValueAppliedDensity(-2.0f);
        deleteButtonParams.rightMargin = getIntValueAppliedDensity(-1.0f);
        deleteButtonParams.addRule(11);
        deleteButton.setLayoutParams(deleteButtonParams);
        if (this.mSdkVersion < 16) {
            previewButton.setBackgroundDrawable(setDrawableSelectImg(mImagePath_pen_preset_bg, mImagePath_pen_preset_bg_press, mImagePath_pen_preset_bg_focus, mImagePath_pen_preset_bg_press));
            presetBg.setBackgroundDrawable(setDrawableImg(mImagePath_pen_preset_bg));
            deleteButton.setBackgroundDrawable(setDrawableSelectImg(mImagePath_snote_delete, mImagePath_snote_delete_press, mImagePath_snote_delete_focus));
        } else {
            previewButton.setBackground(setDrawableSelectImg(mImagePath_pen_preset_bg, mImagePath_pen_preset_bg_press, mImagePath_pen_preset_bg_focus, mImagePath_pen_preset_bg_press));
            presetBg.setBackground(setDrawableImg(mImagePath_pen_preset_bg));
            deleteButton.setBackground(setDrawableSelectImg(mImagePath_snote_delete, mImagePath_snote_delete_press, mImagePath_snote_delete_focus));
        }
        deleteButton.setClickable(true);
        deleteButton.setFocusable(true);
        deleteButton.setId(IB_PEN_PRESET_DELETE_ID);
        relativeLayout.addView(presetBg);
        relativeLayout.addView(previewButton);
        relativeLayout.addView(previewImage);
        relativeLayout.addView(penAlphaPreview);
        relativeLayout.addView(deleteButton);
        return relativeLayout;
    }

    public View getPenPresetListRow() {
        return this.mPresetListItemView;
    }
}
