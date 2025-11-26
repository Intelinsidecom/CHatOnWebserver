package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ChatOnSMSAuthAsk extends MsgBody {
    public static final int PLATFORM_ANDROID = 1;
    public static final int PLATFORM_BADA = 2;
    public static final int PLATFORM_BLACKBERRY = 5;
    public static final int PLATFORM_FEATURE = 3;
    public static final int PLATFORM_IOS = 4;
    public static final int PLATFORM_UNDEFINED = 0;
    private String AccessToken;

    @Min(0)
    private int CountryCode;

    @Min(0)
    private int DevicePlatform;

    @NotNull
    private String DeviceString;

    @NotNull
    @Size(max = 10, min = 10)
    private String GuidSamsungAccount;

    @NotNull
    @Size(max = 64, min = 0)
    private String PhoneNo;

    public String getAccessToken() {
        return this.AccessToken;
    }

    public void setAccessToken(String accessToken) {
        this.AccessToken = accessToken;
    }

    public String getGuidSamsungAccount() {
        return this.GuidSamsungAccount;
    }

    public void setGuidSamsungAccount(String guidSamsungAccount) {
        this.GuidSamsungAccount = guidSamsungAccount;
    }

    public int getDevicePlatform() {
        return this.DevicePlatform;
    }

    public void setDevicePlatform(int devicePlatform) {
        this.DevicePlatform = devicePlatform;
    }

    public int getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(int countryCode) {
        this.CountryCode = countryCode;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public String getDeviceString() {
        return this.DeviceString;
    }

    public void setDeviceString(String deviceString) {
        this.DeviceString = deviceString;
    }
}
