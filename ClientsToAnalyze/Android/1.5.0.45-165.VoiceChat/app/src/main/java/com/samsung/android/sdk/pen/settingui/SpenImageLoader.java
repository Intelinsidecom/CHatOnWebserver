package com.samsung.android.sdk.pen.settingui;

import android.os.Build;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
class SpenImageLoader {
    private SPenImageUtil mDrawableImg;
    private final int mSdkVersion = Build.VERSION.SDK_INT;
    public boolean mLoaded = false;
    private OneStateImage mOneStateImage = new OneStateImage();
    private StateImage mStateImage = new StateImage();

    private static class OneStateImage {
        private ArrayList<View> mViewList = new ArrayList<>();
        private ArrayList<String> mImagePathList = new ArrayList<>();
        private ArrayList<Integer> mWidthList = new ArrayList<>();
        private ArrayList<Integer> mHeightList = new ArrayList<>();
    }

    private static class StateImage {
        private ArrayList<View> mViewList = new ArrayList<>();
        private ArrayList<String> mNormalPathList = new ArrayList<>();
        private ArrayList<String> mPressPathList = new ArrayList<>();
        private ArrayList<String> mFocusPathList = new ArrayList<>();
        private ArrayList<Integer> mWidthList = new ArrayList<>();
        private ArrayList<Integer> mHeightList = new ArrayList<>();
    }

    SpenImageLoader(SPenImageUtil drawableImg) {
        this.mDrawableImg = drawableImg;
    }

    public void close() {
        this.mOneStateImage.mViewList.clear();
        this.mOneStateImage.mViewList = null;
        this.mOneStateImage.mImagePathList.clear();
        this.mOneStateImage.mImagePathList = null;
        this.mOneStateImage.mWidthList.clear();
        this.mOneStateImage.mWidthList = null;
        this.mOneStateImage.mHeightList.clear();
        this.mOneStateImage.mHeightList = null;
        this.mOneStateImage = null;
        this.mStateImage.mViewList.clear();
        this.mStateImage.mViewList = null;
        this.mStateImage.mNormalPathList.clear();
        this.mStateImage.mNormalPathList = null;
        this.mStateImage.mPressPathList.clear();
        this.mStateImage.mPressPathList = null;
        this.mStateImage.mFocusPathList.clear();
        this.mStateImage.mFocusPathList = null;
        this.mStateImage.mWidthList.clear();
        this.mStateImage.mWidthList = null;
        this.mStateImage.mHeightList.clear();
        this.mStateImage.mHeightList = null;
        this.mStateImage = null;
        this.mDrawableImg = null;
    }

    public void addViewSetBackgroundImageLoad(View view, String imagePath) {
        this.mOneStateImage.mViewList.add(view);
        this.mOneStateImage.mImagePathList.add(imagePath);
        this.mOneStateImage.mWidthList.add(-1);
        this.mOneStateImage.mHeightList.add(-1);
    }

    public void addViewSetBackgroundImageLoad(View view, String imagePath, int width, int height) {
        this.mOneStateImage.mViewList.add(view);
        this.mOneStateImage.mImagePathList.add(imagePath);
        this.mOneStateImage.mWidthList.add(Integer.valueOf(width));
        this.mOneStateImage.mHeightList.add(Integer.valueOf(height));
    }

    public void addViewBackgroundSelectableImageLoad(View view, String normalImagePath, String pressPath, String focusPath, int width, int height) {
        this.mStateImage.mViewList.add(view);
        this.mStateImage.mNormalPathList.add(normalImagePath);
        this.mStateImage.mPressPathList.add(pressPath);
        this.mStateImage.mFocusPathList.add(focusPath);
        this.mStateImage.mWidthList.add(Integer.valueOf(width));
        this.mStateImage.mHeightList.add(Integer.valueOf(height));
    }

    public void addViewBackgroundSelectableImageLoad(View view, String normalImagePath, String pressPath, String focusPath) {
        this.mStateImage.mViewList.add(view);
        this.mStateImage.mNormalPathList.add(normalImagePath);
        this.mStateImage.mPressPathList.add(pressPath);
        this.mStateImage.mFocusPathList.add(focusPath);
        this.mStateImage.mWidthList.add(-1);
        this.mStateImage.mHeightList.add(-1);
    }

    public void loadImage() {
        if (!this.mLoaded) {
            this.mLoaded = true;
            for (int i = 0; i < this.mOneStateImage.mViewList.size(); i++) {
                View view = (View) this.mOneStateImage.mViewList.get(i);
                int width = ((Integer) this.mOneStateImage.mWidthList.get(i)).intValue();
                int height = ((Integer) this.mOneStateImage.mHeightList.get(i)).intValue();
                if (this.mSdkVersion < 16) {
                    if (width < 0 && height < 0) {
                        view.setBackgroundDrawable(this.mDrawableImg.setDrawableImg((String) this.mOneStateImage.mImagePathList.get(i)));
                    } else {
                        view.setBackgroundDrawable(this.mDrawableImg.setDrawableImg((String) this.mOneStateImage.mImagePathList.get(i), ((Integer) this.mOneStateImage.mWidthList.get(i)).intValue(), ((Integer) this.mOneStateImage.mHeightList.get(i)).intValue()));
                    }
                } else if (width < 0 && height < 0) {
                    view.setBackground(this.mDrawableImg.setDrawableImg((String) this.mOneStateImage.mImagePathList.get(i)));
                } else {
                    view.setBackground(this.mDrawableImg.setDrawableImg((String) this.mOneStateImage.mImagePathList.get(i), ((Integer) this.mOneStateImage.mWidthList.get(i)).intValue(), ((Integer) this.mOneStateImage.mHeightList.get(i)).intValue()));
                }
            }
            for (int i2 = 0; i2 < this.mStateImage.mViewList.size(); i2++) {
                View view2 = (View) this.mStateImage.mViewList.get(i2);
                int width2 = ((Integer) this.mStateImage.mWidthList.get(i2)).intValue();
                int height2 = ((Integer) this.mStateImage.mHeightList.get(i2)).intValue();
                if (this.mSdkVersion < 16) {
                    if (width2 < 0 && height2 < 0) {
                        view2.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg((String) this.mStateImage.mNormalPathList.get(i2), (String) this.mStateImage.mPressPathList.get(i2), (String) this.mStateImage.mFocusPathList.get(i2)));
                    } else {
                        view2.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg((String) this.mStateImage.mNormalPathList.get(i2), (String) this.mStateImage.mPressPathList.get(i2), (String) this.mStateImage.mFocusPathList.get(i2), width2, height2));
                    }
                } else if (width2 < 0 && height2 < 0) {
                    view2.setBackground(this.mDrawableImg.setDrawableSelectImg((String) this.mStateImage.mNormalPathList.get(i2), (String) this.mStateImage.mPressPathList.get(i2), (String) this.mStateImage.mFocusPathList.get(i2)));
                } else {
                    view2.setBackground(this.mDrawableImg.setDrawableSelectImg((String) this.mStateImage.mNormalPathList.get(i2), (String) this.mStateImage.mPressPathList.get(i2), (String) this.mStateImage.mFocusPathList.get(i2), ((Integer) this.mStateImage.mWidthList.get(i2)).intValue(), ((Integer) this.mStateImage.mHeightList.get(i2)).intValue()));
                }
            }
        }
    }
}
