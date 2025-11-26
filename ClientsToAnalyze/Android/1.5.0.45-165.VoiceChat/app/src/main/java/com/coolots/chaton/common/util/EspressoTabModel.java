package com.coolots.chaton.common.util;

import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.infraware.office.evengine.InterfaceC0507E;

/* loaded from: classes.dex */
public class EspressoTabModel implements ModelInfomation {
    @Override // com.coolots.chaton.common.util.ModelInfomation
    public boolean isTabDevice() {
        return true;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewX() {
        return 24;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewX() {
        return 430;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewY() {
        return ChatONHideMeImgData.IMAGE_DEFAULT_WIDTH;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewY() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_IMAGE_EFFECT_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingRight() {
        return 24;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingRight() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SELECT_ALL_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingBottom() {
        return 177;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingBottom() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewPaddingBottom() {
        return 195;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewPaddingBottom() {
        return 18;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortFullHeight() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandFullHeight() {
        return 736;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandFullWidth() {
        return 552;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositonTopMargin() {
        return 98;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositionDownMargin() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BWP_SELECT_MARK_CANCEL_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositonTopMargin() {
        return 68;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositionDownMargin() {
        return 342;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPreviewHeight() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_CARET_HOME_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPreviewWidth() {
        return ScreenSharePacket.SCREEN_SHARE_DOCS_CMD_PEN_MODE;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getStatusBarLength() {
        return 50;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewHeight() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_CARET_HOME_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewWidth() {
        return ScreenSharePacket.SCREEN_SHARE_DOCS_CMD_PEN_MODE;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getCallStatusBarHeight() {
        return 96;
    }
}
