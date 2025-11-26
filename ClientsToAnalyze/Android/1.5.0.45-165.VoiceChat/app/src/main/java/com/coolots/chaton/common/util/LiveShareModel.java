package com.coolots.chaton.common.util;

import com.infraware.office.evengine.InterfaceC0507E;
import com.sds.coolots.common.util.ModelInfoUtil;

/* loaded from: classes.dex */
public class LiveShareModel implements ModelInfomation {
    private int bottom_up_height;
    private boolean mIsOutgoing;
    private int soft_key_width;
    private int status_bar_height;
    private boolean mIsFullScreen = false;
    private boolean mIsBottomUp = false;

    public LiveShareModel(boolean isOutgoing) {
        this.mIsOutgoing = false;
        this.soft_key_width = 84;
        this.bottom_up_height = 0;
        this.status_bar_height = 50;
        this.mIsOutgoing = isOutgoing;
        if (this.mIsOutgoing) {
            this.status_bar_height = 0;
        } else {
            this.status_bar_height = 50;
        }
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            this.soft_key_width = 84;
        } else {
            this.soft_key_width = 0;
        }
        this.bottom_up_height = 0;
    }

    public void setIsFullScreen(boolean isFullScreen) {
        this.mIsFullScreen = isFullScreen;
    }

    public void setIsBottomUp(boolean isBottomUp) {
        this.mIsBottomUp = isBottomUp;
        if (this.mIsBottomUp) {
            this.bottom_up_height = 148;
        } else {
            this.bottom_up_height = 0;
        }
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public boolean isTabDevice() {
        return false;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPreviewHeight() {
        return 324;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPreviewWidth() {
        return 244;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getStatusBarLength() {
        return this.status_bar_height;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewX() {
        return 166;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewY() {
        return (452 - this.status_bar_height) - this.bottom_up_height;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingRight() {
        if (this.mIsOutgoing || this.mIsFullScreen) {
            return 0;
        }
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SCREENMODE_THUMBNAIL_EVENT;
        }
        return 388;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingBottom() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewPaddingBottom() {
        return (this.mIsOutgoing || this.mIsFullScreen) ? 0 : 6;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandFullHeight() {
        if (this.mIsOutgoing) {
            return 1280;
        }
        if (this.mIsFullScreen) {
            return 1280 - this.soft_key_width;
        }
        return 892;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandFullWidth() {
        return (720 - this.status_bar_height) - this.bottom_up_height;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositonTopMargin() {
        return this.mIsOutgoing ? 0 : 76;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositionDownMargin() {
        return 476 - this.status_bar_height;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewX() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewY() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingRight() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingBottom() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewPaddingBottom() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortFullHeight() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositonTopMargin() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositionDownMargin() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewHeight() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewWidth() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getCallStatusBarHeight() {
        return 96;
    }
}
