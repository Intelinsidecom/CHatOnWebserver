package com.vlingo.sdk.internal.recognizer;

import android.os.Build;
import com.vlingo.sdk.VLSdk;
import com.vlingo.sdk.internal.deviceinfo.PhoneInfo;
import com.vlingo.sdk.internal.location.LocationUtils;
import com.vlingo.sdk.internal.settings.Settings;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.util.SDKDebugSettings;
import java.util.UUID;

/* loaded from: classes.dex */
public class ClientMeta {
    private static ClientMeta instance = null;
    String deviceID = null;
    String deviceModel = null;
    String deviceOS = null;
    String hardwareID = null;
    Boolean fakeLatLong = false;

    public static ClientMeta getInstance() {
        if (instance == null) {
            instance = new ClientMeta();
        }
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public String getCarrier() {
        return PhoneInfo.getInstance().getCurrentCarrier();
    }

    public String getCarrierCountry() {
        SDKDebugSettings ds = VLSdk.getInstance().getDebugSettings();
        if (ds != null) {
            String carrierCountry = ds.getCarrierCountry();
            if (!StringUtils.isNullOrWhiteSpace(carrierCountry)) {
                return carrierCountry;
            }
        }
        return PhoneInfo.getInstance().getCarrierCountry();
    }

    public String getDeviceID() {
        String uuid = Settings.getPersistentString(Settings.KEY_UUID, null);
        if (uuid == null) {
            String uuid2 = UUID.randomUUID().toString().replaceAll("-", "");
            Settings.setPersistentString(Settings.KEY_UUID, uuid2);
            return uuid2;
        }
        return uuid;
    }

    public int getVendorID() {
        return PhoneInfo.getInstance().getVendorID();
    }

    public String getDeviceMake() {
        return Build.MANUFACTURER;
    }

    public String getDeviceOSName() {
        return "Android";
    }

    public String getDeviceModel() {
        if (this.deviceModel == null) {
            this.deviceModel = PhoneInfo.getInstance().getModel();
        }
        return this.deviceModel;
    }

    public String getDeviceOS() {
        return PhoneInfo.getInstance().getOSVersion();
    }

    public String getLanguage() {
        return Settings.LANGUAGE;
    }

    public String getPhoneNumber() {
        return "";
    }

    public String getLocation() {
        SDKDebugSettings ds = VLSdk.getInstance().getDebugSettings();
        if (ds != null) {
            String location = ds.getLocation();
            if (!StringUtils.isNullOrWhiteSpace(location)) {
                return location;
            }
        }
        String location2 = LocationUtils.getCellTowerInfo();
        if (location2 == null) {
            location2 = "";
        }
        return location2;
    }

    public String geHardwareID() {
        if (this.hardwareID == null) {
            this.hardwareID = PhoneInfo.getInstance().getDeviceID();
        }
        return this.hardwareID;
    }
}
