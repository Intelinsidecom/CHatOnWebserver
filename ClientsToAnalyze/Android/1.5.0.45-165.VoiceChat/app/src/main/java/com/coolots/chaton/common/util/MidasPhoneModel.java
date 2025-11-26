package com.coolots.chaton.common.util;

import com.infraware.office.evengine.InterfaceC0507E;

/* loaded from: classes.dex */
public class MidasPhoneModel implements ModelInfomation {
    @Override // com.coolots.chaton.common.util.ModelInfomation
    public boolean isTabDevice() {
        return false;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewX() {
        return 8;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewX() {
        return 584;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewY() {
        return 628;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewY() {
        return 431;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingRight() {
        return 8;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingRight() {
        return 388;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingBottom() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingBottom() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewPaddingBottom() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewPaddingBottom() {
        return 12;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortFullHeight() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandFullHeight() {
        return 892;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandFullWidth() {
        return 670;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositonTopMargin() {
        return 160;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositionDownMargin() {
        return 636;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositonTopMargin() {
        return 76;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositionDownMargin() {
        return 426;
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
        return 50;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewHeight() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BORDER_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewWidth() {
        return 228;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getCallStatusBarHeight() {
        return 96;
    }
}
