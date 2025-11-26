package com.coolots.chaton.common.util;

import com.infraware.office.evengine.InterfaceC0507E;

/* loaded from: classes.dex */
public class NotePhoneModel implements ModelInfomation {
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
        return 560;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewY() {
        return 628;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewY() {
        return 498;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingRight() {
        return 12;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingRight() {
        return 388;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPaddingBottom() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_JUSTIFY_ALIGN_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPaddingBottom() {
        return 0;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortPreviewPaddingBottom() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_CARET_PAGEUP_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewPaddingBottom() {
        return 6;
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
        return 170;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPortRepositionDownMargin() {
        return 729;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositonTopMargin() {
        return 76;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandRepositionDownMargin() {
        return 498;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPreviewHeight() {
        return 324;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getPreviewWidth() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BOTTOM_ALIGN_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getStatusBarLength() {
        return 50;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewHeight() {
        return 324;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getLandPreviewWidth() {
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BOTTOM_ALIGN_EVENT;
    }

    @Override // com.coolots.chaton.common.util.ModelInfomation
    public int getCallStatusBarHeight() {
        return 96;
    }
}
