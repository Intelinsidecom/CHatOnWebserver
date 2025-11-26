package com.coolots.chaton.call.screenshare.util;

import com.samsung.spen.settings.SettingStrokeInfo;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class SettingPacket {
    private static final String CLASSNAME = "[SettingPacket]";

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public static byte[] makeSettingStrokeInfo(int userid, SettingStrokeInfo SettingInfo) {
        logI("makeSettingStrokeInfo : " + SettingInfo.getStrokeAlpha() + " " + SettingInfo.getStrokeColor() + " " + SettingInfo.getStrokeStyle() + " " + SettingInfo.getStrokeWidth());
        byte[] binSettingInfo = new byte[20];
        byte[] tmpArr = PenWriteNetwork.intToByte(userid);
        System.arraycopy(tmpArr, 0, binSettingInfo, 0, 4);
        int pos = 0 + 4;
        byte[] tmpArr2 = PenWriteNetwork.intToByte(SettingInfo.getStrokeAlpha());
        System.arraycopy(tmpArr2, 0, binSettingInfo, pos, 4);
        int pos2 = pos + 4;
        byte[] tmpArr3 = PenWriteNetwork.intToByte(SettingInfo.getStrokeColor());
        System.arraycopy(tmpArr3, 0, binSettingInfo, pos2, 4);
        int pos3 = pos2 + 4;
        byte[] tmpArr4 = PenWriteNetwork.intToByte(SettingInfo.getStrokeStyle());
        System.arraycopy(tmpArr4, 0, binSettingInfo, pos3, 4);
        byte[] tmpArr5 = PenWriteNetwork.floatToByte(SettingInfo.getStrokeWidth());
        System.arraycopy(tmpArr5, 0, binSettingInfo, pos3 + 4, 4);
        return binSettingInfo;
    }

    public static byte[] makeSettingStrokeInfo(int userid, SpenSettingInfo SettingInfo) {
        logI("makeSettingStrokeInfo : " + SettingInfo.getMode() + " " + SettingInfo.getStrokeColor() + " " + SettingInfo.getStrokeName() + " " + SettingInfo.getStrokeWidth());
        byte[] binSettingInfo = new byte[(SettingInfo.getStrokeName() == null ? 0 : SettingInfo.getStrokeName().getBytes().length) + 16];
        byte[] tmpArr = PenWriteNetwork.intToByte(SettingInfo.getMode());
        System.arraycopy(tmpArr, 0, binSettingInfo, 0, 4);
        int pos = 0 + 4;
        byte[] tmpArr2 = PenWriteNetwork.intToByte(userid);
        System.arraycopy(tmpArr2, 0, binSettingInfo, pos, 4);
        int pos2 = pos + 4;
        byte[] tmpArr3 = PenWriteNetwork.intToByte(SettingInfo.getStrokeColor());
        System.arraycopy(tmpArr3, 0, binSettingInfo, pos2, 4);
        int pos3 = pos2 + 4;
        if (SettingInfo.getStrokeName() != null) {
            byte[] textArr = SettingInfo.getStrokeName().getBytes();
            System.arraycopy(textArr, 0, binSettingInfo, pos3, textArr.length);
            pos3 = textArr.length + 12;
        }
        byte[] tmpArr4 = PenWriteNetwork.floatToByte(SettingInfo.getStrokeWidth());
        System.arraycopy(tmpArr4, 0, binSettingInfo, pos3, 4);
        return binSettingInfo;
    }

    public static MultiSettingStrokeInfo parserSettingStrokeInfo(byte[] bin) {
        MultiSettingStrokeInfo multiSttingInfo = new MultiSettingStrokeInfo();
        multiSttingInfo.settingInfo = new SettingStrokeInfo();
        byte[] tmpArr = new byte[4];
        System.arraycopy(bin, 0, tmpArr, 0, 4);
        int iValue = PenWriteNetwork.byteToInt(tmpArr);
        multiSttingInfo.userId = iValue;
        int pos = 0 + 4;
        System.arraycopy(bin, pos, tmpArr, 0, 4);
        int iValue2 = PenWriteNetwork.byteToInt(tmpArr);
        multiSttingInfo.settingInfo.setStrokeAlpha(iValue2);
        int pos2 = pos + 4;
        System.arraycopy(bin, pos2, tmpArr, 0, 4);
        int iValue3 = PenWriteNetwork.byteToInt(tmpArr);
        multiSttingInfo.settingInfo.setStrokeColor(iValue3);
        int pos3 = pos2 + 4;
        System.arraycopy(bin, pos3, tmpArr, 0, 4);
        int iValue4 = PenWriteNetwork.byteToInt(tmpArr);
        multiSttingInfo.settingInfo.setStrokeStyle(iValue4);
        System.arraycopy(bin, pos3 + 4, tmpArr, 0, 4);
        float fvalue = PenWriteNetwork.byteToFloat(tmpArr);
        multiSttingInfo.settingInfo.setStrokeWidth(fvalue);
        return multiSttingInfo;
    }

    public static MultiSettingStrokeInfo parserSpenSettingStrokeInfo(byte[] bin) {
        MultiSettingStrokeInfo multiSttingInfo = new MultiSettingStrokeInfo();
        byte[] tmpArr = new byte[4];
        System.arraycopy(bin, 0, tmpArr, 0, 4);
        multiSttingInfo.spenSettingInfo = new SpenSettingInfo(PenWriteNetwork.byteToInt(tmpArr));
        int pos = 0 + 4;
        System.arraycopy(bin, pos, tmpArr, 0, 4);
        int iValue = PenWriteNetwork.byteToInt(tmpArr);
        multiSttingInfo.userId = iValue;
        multiSttingInfo.spenSettingInfo.setUserId(iValue);
        int pos2 = pos + 4;
        System.arraycopy(bin, pos2, tmpArr, 0, 4);
        multiSttingInfo.spenSettingInfo.setStrokeColor(PenWriteNetwork.byteToInt(tmpArr));
        int pos3 = pos2 + 4;
        if (bin.length != 16) {
            byte[] stringData = new byte[bin.length - 16];
            System.arraycopy(bin, pos3, stringData, 0, bin.length - 16);
            multiSttingInfo.spenSettingInfo.setStrokeName(new String(stringData, 0, bin.length - 16));
            pos3 = (bin.length - 16) + 12;
        }
        System.arraycopy(bin, pos3, tmpArr, 0, 4);
        float fvalue = PenWriteNetwork.byteToFloat(tmpArr);
        multiSttingInfo.spenSettingInfo.setStrokeWidth(fvalue);
        return multiSttingInfo;
    }

    public static SettingStrokeInfo copySettingInfo(SettingStrokeInfo SettingInfo) {
        SettingStrokeInfo tempSetting = new SettingStrokeInfo();
        tempSetting.setStrokeAlpha(SettingInfo.getStrokeAlpha());
        tempSetting.setStrokeColor(SettingInfo.getStrokeColor());
        tempSetting.setStrokeStyle(SettingInfo.getStrokeStyle());
        tempSetting.setStrokeWidth(SettingInfo.getStrokeWidth());
        return tempSetting;
    }

    public static SpenSettingInfo copySettingInfo(int mode, SpenSettingInfo SettingInfo) {
        SpenSettingInfo tempSetting = new SpenSettingInfo(mode);
        tempSetting.setStrokeColor(SettingInfo.getStrokeColor());
        tempSetting.setStrokeName(SettingInfo.getStrokeName());
        tempSetting.setStrokeWidth(SettingInfo.getStrokeWidth());
        return tempSetting;
    }

    public static boolean equalsSettingInfo(SettingStrokeInfo sourSettingInfo, SettingStrokeInfo destSettingInfo) {
        return sourSettingInfo.getStrokeAlpha() == destSettingInfo.getStrokeAlpha() && sourSettingInfo.getStrokeColor() == destSettingInfo.getStrokeColor() && sourSettingInfo.getStrokeStyle() == destSettingInfo.getStrokeStyle() && sourSettingInfo.getStrokeWidth() == destSettingInfo.getStrokeWidth();
    }

    public static boolean equalsSettingInfo(SpenSettingInfo sourSettingInfo, SpenSettingInfo destSettingInfo) {
        if (sourSettingInfo.getMode() == destSettingInfo.getMode() && sourSettingInfo.getStrokeColor() == destSettingInfo.getStrokeColor() && ((sourSettingInfo.getStrokeName() == null || sourSettingInfo.getStrokeName().equals(destSettingInfo.getStrokeName())) && sourSettingInfo.getStrokeWidth() == destSettingInfo.getStrokeWidth())) {
            return true;
        }
        return false;
    }
}
