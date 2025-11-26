package com.vlingo.sdk.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class SDKDebugSettings {
    private String mLocation = null;
    private String mCarrierCountry = null;
    private boolean mForceNonDM = false;
    private boolean mLogRecoWaveform = false;
    private ServerResponseLoggingState serverResponseLoggingState = ServerResponseLoggingState.NONE;
    private String mRawServerLogBase = "rawServerLog";

    public enum ServerResponseLoggingState {
        NONE("None"),
        SAVE("Save"),
        REPLAY("Replay");

        private static final Map<String, ServerResponseLoggingState> lookup = new HashMap();
        private static String[] stringValues;
        private String code;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ServerResponseLoggingState[] valuesCustom() {
            ServerResponseLoggingState[] serverResponseLoggingStateArrValuesCustom = values();
            int length = serverResponseLoggingStateArrValuesCustom.length;
            ServerResponseLoggingState[] serverResponseLoggingStateArr = new ServerResponseLoggingState[length];
            System.arraycopy(serverResponseLoggingStateArrValuesCustom, 0, serverResponseLoggingStateArr, 0, length);
            return serverResponseLoggingStateArr;
        }

        static {
            EnumSet<ServerResponseLoggingState> all = EnumSet.allOf(ServerResponseLoggingState.class);
            stringValues = new String[all.size()];
            int i = 0;
            Iterator it = all.iterator();
            while (it.hasNext()) {
                ServerResponseLoggingState s = (ServerResponseLoggingState) it.next();
                stringValues[i] = s.getCode();
                lookup.put(s.getCode(), s);
                i++;
            }
        }

        ServerResponseLoggingState(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }

        public static String[] getStringValues() {
            return stringValues;
        }

        public static ServerResponseLoggingState get(String code) {
            return lookup.get(code);
        }
    }

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

    public String getmRawServerLogBase() {
        return this.mRawServerLogBase;
    }

    public void setmRawServerLogBase(String mRawServerLogBase) {
        this.mRawServerLogBase = mRawServerLogBase;
    }

    public ServerResponseLoggingState getServerResponseLoggingState() {
        return this.serverResponseLoggingState;
    }

    public void setServerResponseLoggingState(ServerResponseLoggingState serverResponseLoggingState) {
        this.serverResponseLoggingState = serverResponseLoggingState;
    }
}
