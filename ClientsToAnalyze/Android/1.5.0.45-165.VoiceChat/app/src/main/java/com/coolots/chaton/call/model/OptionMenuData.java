package com.coolots.chaton.call.model;

/* loaded from: classes.dex */
class OptionMenuData {
    protected int mIcon;
    protected boolean mIsEnable = true;
    protected String mTitle;

    public OptionMenuData(int icon, String title) {
        this.mIcon = icon;
        this.mTitle = title;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isEnable() {
        return this.mIsEnable;
    }

    public void setIcon(int icon) {
        this.mIcon = icon;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setEnable(boolean isEnable) {
        this.mIsEnable = isEnable;
    }
}
