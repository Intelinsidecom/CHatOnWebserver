package com.coolots.chaton.common.util;

import com.sds.coolots.common.util.ModelInfoUtil;

/* loaded from: classes.dex */
public class ModelCreator {
    public static final int DEVICE_C1 = 3;
    public static final int DEVICE_ESPRESSO = 2;
    public static final int DEVICE_FULL_HD = 5;
    public static final int DEVICE_MIDAS = 0;
    public static final int DEVICE_NOTE = 1;
    public static final int DEVICE_S2 = 4;

    public static ModelInfomation getModelInfo(int displayWidth, int displayHeight) {
        switch (checkDeviceModel(displayWidth, displayHeight)) {
            case 1:
                return new NotePhoneModel();
            case 2:
                return new EspressoTabModel();
            case 3:
            default:
                return new MidasPhoneModel();
            case 4:
                return new S2PhoneModel();
            case 5:
                return new FullHDPhoneModel();
        }
    }

    public static int checkDeviceModel(int displayWidth, int displayHeight) {
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            return 0;
        }
        if (displayWidth == 600 && displayHeight == 976) {
            return 2;
        }
        if (displayWidth == 1024 && displayHeight == 552) {
            return 2;
        }
        if (displayWidth == 800 && displayHeight == 1280) {
            return 1;
        }
        if (displayWidth == 1280 && displayHeight == 800) {
            return 1;
        }
        if (displayWidth == 720 && displayHeight == 1280) {
            return 0;
        }
        if (displayWidth == 1280 && displayHeight == 720) {
            return 0;
        }
        if (displayWidth == 720 && displayHeight == 1184) {
            return 3;
        }
        if (displayWidth == 1196 && displayHeight == 720) {
            return 3;
        }
        if (displayWidth == 480 && displayHeight == 800) {
            return 4;
        }
        if (displayWidth == 800 && displayHeight == 480) {
            return 4;
        }
        return ((displayWidth == 1080 && displayHeight == 1920) || (displayWidth == 1920 && displayHeight == 1080)) ? 5 : 0;
    }
}
