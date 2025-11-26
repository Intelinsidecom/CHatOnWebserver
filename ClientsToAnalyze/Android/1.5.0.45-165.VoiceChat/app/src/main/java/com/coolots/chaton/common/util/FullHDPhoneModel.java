package com.coolots.chaton.common.util;

import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.infraware.office.evengine.InterfaceC0507E;

/* loaded from: classes.dex */
public class FullHDPhoneModel implements ModelInfomation {
    @Override // com.coolots.chaton.common.util.ModelInfomation
    public boolean isTabDevice() {
        return false;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getStatusBarLength() {
        return 75;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getCallStatusBarHeight() {
        return 144;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewWidth() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_OBJECT_ATT_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewHeight() {
        return 390;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewX() {
        return 936;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewY() {
        return 699;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingRight() {
        return 582;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingBottom() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewPaddingBottom() {
        return 18;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositonTopMargin() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositionDownMargin() {
        return 709;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandFullHeight() {
        return 1337;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandFullWidth() {
        return 1005;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPreviewWidth() {
        return 315;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPreviewHeight() {
        return 420;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewX() {
        return 12;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewY() {
        return 1152;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingRight() {
        return 12;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingBottom() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_NEW_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewPaddingBottom() {
        return ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortFullHeight() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositonTopMargin() {
        return 144;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositionDownMargin() {
        return 1164;
    }
}
