package com.vlingo.sdk.internal.recognizer;

import android.util.Log;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.internal.net.ConnectionProvider;
import com.vlingo.sdk.internal.recognizer.asr.ASRManager;
import com.vlingo.sdk.internal.recognizer.sr3.SR3Manager;
import com.vlingo.sdk.internal.settings.Settings;

/* loaded from: classes.dex */
public abstract class SRManager {
    public static final int DEFAULT_TIMEOUT = -1;
    public static final boolean USE_ASR = true;
    private int mConnectTimeout = -1;
    private int mReadTimeout = -1;

    public abstract void addXMLResponseListener(XMLResponseListener xMLResponseListener);

    public abstract void destroy();

    public abstract String getLastGuttID();

    public abstract void init(SRServerDetails sRServerDetails, ClientMeta clientMeta, SoftwareMeta softwareMeta);

    public abstract SRRequest newRequest(SRContext sRContext, SRRequestListener sRRequestListener);

    public abstract SRRequest newRequest(SRContext sRContext, SRRequestListener sRRequestListener, boolean z);

    public abstract boolean readyForRecognition();

    public abstract void removeXMLResponseListener(XMLResponseListener xMLResponseListener);

    public abstract void sendStatistics(SRStatistics sRStatistics);

    public abstract void sendStatsCollection(SRStatisticsCollection sRStatisticsCollection);

    public abstract void setServer(SRServerDetails sRServerDetails);

    public static boolean isAsrManager() {
        return true;
    }

    public static SRManager create(ConnectionProvider connectionProvider, TimingRepository timings) {
        boolean useAsrManager = Settings.getPersistentBoolean(Settings.KEY_ASR_MANAGER, true);
        Log.d("SRManager", "using " + (useAsrManager ? "ASRManager" : "SR3Manager"));
        return useAsrManager ? new ASRManager(connectionProvider, timings) : new SR3Manager(connectionProvider, timings);
    }

    public int getConnectTimeout() {
        int optimalConnectTimeout = this.mConnectTimeout == -1 ? ConnectionManager.getOptimalConnectTimeout() : this.mConnectTimeout;
        this.mConnectTimeout = optimalConnectTimeout;
        return optimalConnectTimeout;
    }

    public int getReadTimeout() {
        int optimalNetworkTimeout = this.mReadTimeout == -1 ? ConnectionManager.getOptimalNetworkTimeout() : this.mReadTimeout;
        this.mReadTimeout = optimalNetworkTimeout;
        return optimalNetworkTimeout;
    }

    public void setConnectTimeout(int timeout) {
        this.mConnectTimeout = timeout;
    }

    public void setReadTimeout(int timeout) {
        this.mReadTimeout = timeout;
    }
}
