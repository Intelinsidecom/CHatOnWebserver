package com.vlingo.sdk.util;

/* loaded from: classes.dex */
public class DebugSettings {
    private String mLocation = null;
    private String mCarrierCountry = null;
    private boolean mForceNonDM = false;
    private boolean mLogRecoWaveform = false;

    public String getLocation() {
        return this.mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

    public String getCarrierCountry() {
        return this.mCarrierCountry;
    }

    public void setCarrierCountry(String carrierCountry) {
        this.mCarrierCountry = carrierCountry;
    }

    public boolean isForceNonDM() {
        return this.mForceNonDM;
    }

    public void setForceNonDM(boolean forceNonDM) {
        this.mForceNonDM = forceNonDM;
    }

    public boolean isLogRecoWaveform() {
        return this.mLogRecoWaveform;
    }

    public void setLogRecoWaveform(boolean logWaveForm) {
        this.mLogRecoWaveform = logWaveForm;
    }
}
