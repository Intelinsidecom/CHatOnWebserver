package com.coolots.chaton.call.view.layout.video;

import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.VideoCallActivity;

/* loaded from: classes.dex */
public class IVideoCallOptionMenu {
    public static final int AVATAR = 3;
    public static final int EMOTI_ANI = 1;
    public static final int NONE = 0;
    public static final int THEME_SHOT = 2;
    private VideoCallAvatarOptionMenu mAvatarLayout;
    private VideoCallEmotiAnimationLayout mEmotiAnimationLayout;
    private ChatOnCallActivity mParentActivity;
    private int mStatus;
    private VideoCallThemeShotLayout mThemeShotLayout;

    public void setParent(VideoCallActivity parent, boolean isLandscapeMode) {
        this.mParentActivity = parent;
        this.mEmotiAnimationLayout.setParent(parent, isLandscapeMode);
        this.mThemeShotLayout.setParent(parent, isLandscapeMode);
        this.mAvatarLayout.setParent(parent, isLandscapeMode);
    }

    public IVideoCallOptionMenu(VideoCallActivity videoCallActivity) {
        this.mParentActivity = videoCallActivity;
    }

    public void setOptionMenuItems(VideoCallEmotiAnimationLayout emotiMenu, VideoCallThemeShotLayout themeShotMenu, VideoCallAvatarOptionMenu avatarMenu) {
        this.mEmotiAnimationLayout = emotiMenu;
        this.mThemeShotLayout = themeShotMenu;
        this.mAvatarLayout = avatarMenu;
        resetAnimationData();
    }

    public void resetAnimationData() {
        this.mEmotiAnimationLayout.setVisibility(8);
        this.mThemeShotLayout.setVisibility(8);
        this.mAvatarLayout.setVisibility(8);
    }

    public int reStartAnimation() {
        if (this.mStatus == 1) {
            this.mEmotiAnimationLayout.reStartAnimation();
        } else if (this.mStatus == 2) {
            this.mThemeShotLayout.reStartAnimation();
        } else if (this.mThemeShotLayout.getChangedThemeShot() && this.mStatus == 0) {
            this.mThemeShotLayout.setThemeShot();
        }
        this.mThemeShotLayout.initData();
        return this.mStatus;
    }

    public void changeStatus(int status) {
        this.mStatus = status;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isShowingAnyMenu() {
        if (this.mStatus != 0) {
            return true;
        }
        return false;
    }

    public void showOptionMenu() {
        resetAnimationData();
        if (this.mStatus != 0) {
            if (this.mStatus == 1) {
                this.mEmotiAnimationLayout.setVisibility(0);
                this.mEmotiAnimationLayout.displayEmotionalAnimation();
            } else if (this.mStatus == 2) {
                this.mThemeShotLayout.setVisibility(0);
                this.mThemeShotLayout.displayThemeShot();
            } else if (this.mStatus == 3) {
                this.mAvatarLayout.setVisibility(0);
            }
        }
    }

    public void showOptionMenuForP2P() {
        if (this.mStatus != 0) {
            if (this.mStatus == 1) {
                this.mEmotiAnimationLayout.displayEmotionalAutoOn();
            } else if (this.mStatus == 2) {
                this.mThemeShotLayout.displayThemeShotForP2P();
            }
        }
    }

    public void startHideMe() {
        this.mThemeShotLayout.startHideMe();
    }

    public void stopHideMe() {
        this.mThemeShotLayout.setHideMe(false);
    }

    public void refreshOptionMenu() {
        this.mParentActivity.checkCallInstanceNRefresh();
        if (this.mStatus == 1) {
            this.mEmotiAnimationLayout.setAutoMode(false);
        } else if (this.mStatus == 2) {
            this.mThemeShotLayout.selectTheme();
        }
    }

    public void stopFunction() {
        resetAnimationData();
        this.mParentActivity.closeThemeShotEmotionalAnimation();
    }

    public boolean isAlwaysMode() {
        return this.mEmotiAnimationLayout.isAutoMode();
    }

    public void setAlwaysMode(Boolean flag) {
        this.mEmotiAnimationLayout.setAlwaysMode(flag.booleanValue());
    }
}
