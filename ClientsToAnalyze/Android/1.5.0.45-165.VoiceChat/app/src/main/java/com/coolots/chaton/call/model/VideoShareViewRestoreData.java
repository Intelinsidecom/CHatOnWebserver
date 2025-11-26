package com.coolots.chaton.call.model;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.HashMap;

/* loaded from: classes.dex */
public class VideoShareViewRestoreData implements DisposeInterface {
    private static final String CLASSNAME = "[VideoShareViewRestoreData]";
    private static final String KEY_BACK_CAMERA_TOGGLE = "BACK_CAMERA_TOGGLE";
    private static final String KEY_BUDDY_IMAGE_ONLY = "BUDDY_IMAGE_ONLY";
    private static final String KEY_CARTOON_VIEW = "CARTOON_VIEW";
    private static final String KEY_CHANGE_PREVIEW = "CHANGE_PREVIEW";
    private static final String KEY_EMOTIONAL_AUTO = "EMOTIONAL_AUTO";
    private static final String KEY_MY_IMAGE_ONLY = "MY_IMAGE_ONLY";
    private static final String KEY_THEME_EMOTIONAL_ANI = "THEME_EMOTIONAL_ANI";
    private static final String KEY_THEME_SHOT_ACTIVE = "THEME_SHOT_ACTIVE";
    private static final String KEY_THEME_SHOT_SELECT_NO = "THEME_SHOT_SELECT_NO";
    private static final String KEY_THEME_SHOT_SUB_SELECT_NO = "THEME_SHOT_SUB_SELECT_NO";
    private static final String KEY_USE_HIDEME_IMAGE = "USE_HIDEME_IMAGE";
    private HashMap<String, Object> mData = new HashMap<>();

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public HashMap<String, Object> getData() {
        description();
        return this.mData;
    }

    public boolean getBuddyImageOnly() {
        return ((Boolean) this.mData.get(KEY_BUDDY_IMAGE_ONLY)).booleanValue();
    }

    public boolean getChangePreview() {
        return ((Boolean) this.mData.get(KEY_CHANGE_PREVIEW)).booleanValue();
    }

    public int getBackCameraToggle() {
        return ((Integer) this.mData.get(KEY_BACK_CAMERA_TOGGLE)).intValue();
    }

    public boolean getUseHideMe() {
        return ((Boolean) this.mData.get(KEY_USE_HIDEME_IMAGE)).booleanValue();
    }

    public boolean getMyImageOnly() {
        return ((Boolean) this.mData.get(KEY_MY_IMAGE_ONLY)).booleanValue();
    }

    public boolean getThemeEmotionalAnimationVisible() {
        return ((Boolean) this.mData.get(KEY_THEME_EMOTIONAL_ANI)).booleanValue();
    }

    public boolean getCartoonViewVisible() {
        return ((Boolean) this.mData.get(KEY_CARTOON_VIEW)).booleanValue();
    }

    public boolean getIsEmotionalAuto() {
        return ((Boolean) this.mData.get(KEY_EMOTIONAL_AUTO)).booleanValue();
    }

    public boolean getIsThemeShot() {
        return ((Boolean) this.mData.get(KEY_THEME_SHOT_ACTIVE)).booleanValue();
    }

    public int getThemeShotSelectedNo() {
        return ((Integer) this.mData.get(KEY_THEME_SHOT_SELECT_NO)).intValue();
    }

    public int getThemeShotSubSelectedNo() {
        return ((Integer) this.mData.get(KEY_THEME_SHOT_SUB_SELECT_NO)).intValue();
    }

    public void setData(Object obj) {
        this.mData = (HashMap) obj;
    }

    public void setBuddyImageOnly(boolean data) {
        this.mData.put(KEY_BUDDY_IMAGE_ONLY, Boolean.valueOf(data));
    }

    public void setChangePreview(boolean data) {
        this.mData.put(KEY_CHANGE_PREVIEW, Boolean.valueOf(data));
    }

    public void setBackCameraToggle(int data) {
        this.mData.put(KEY_BACK_CAMERA_TOGGLE, Integer.valueOf(data));
    }

    public void setUseHideMe(boolean data) {
        this.mData.put(KEY_USE_HIDEME_IMAGE, Boolean.valueOf(data));
    }

    public void setMyImageOnly(boolean data) {
        this.mData.put(KEY_MY_IMAGE_ONLY, Boolean.valueOf(data));
    }

    public void setThemeEmotionalAnimationVisible(boolean data) {
        this.mData.put(KEY_THEME_EMOTIONAL_ANI, Boolean.valueOf(data));
    }

    public void setCartoonViewVisible(boolean data) {
        this.mData.put(KEY_CARTOON_VIEW, Boolean.valueOf(data));
    }

    public void setIsEmotionalAuto(boolean data) {
        this.mData.put(KEY_EMOTIONAL_AUTO, Boolean.valueOf(data));
    }

    public void setIsThemeShot(boolean data) {
        this.mData.put(KEY_THEME_SHOT_ACTIVE, Boolean.valueOf(data));
    }

    public void setThemeShotSelectedNo(int data) {
        this.mData.put(KEY_THEME_SHOT_SELECT_NO, Integer.valueOf(data));
    }

    public void setThemeShotSubSelectedNo(int data) {
        this.mData.put(KEY_THEME_SHOT_SUB_SELECT_NO, Integer.valueOf(data));
    }

    public void description() {
        logI("<stored data>++");
        logI("BUDDY_IMAGE_ONLY " + this.mData.get(KEY_BUDDY_IMAGE_ONLY));
        logI("CHANGE_PREVIEW " + this.mData.get(KEY_CHANGE_PREVIEW));
        logI("BACK_CAMERA_TOGGLE " + this.mData.get(KEY_BACK_CAMERA_TOGGLE));
        logI("USE_HIDEME_IMAGE " + this.mData.get(KEY_USE_HIDEME_IMAGE));
        logI("MY_IMAGE_ONLY " + this.mData.get(KEY_MY_IMAGE_ONLY));
        logI(KEY_CARTOON_VIEW + this.mData.get(KEY_CARTOON_VIEW));
        logI("<stored data>--");
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mData != null) {
            this.mData.clear();
            this.mData = null;
        }
    }
}
