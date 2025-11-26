package com.vlingo.sdk.internal.recognizer.asr;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionProvider;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.SRManager;
import com.vlingo.sdk.internal.recognizer.SRRequest;
import com.vlingo.sdk.internal.recognizer.SRRequestListener;
import com.vlingo.sdk.internal.recognizer.SRServerDetails;
import com.vlingo.sdk.internal.recognizer.SRStatistics;
import com.vlingo.sdk.internal.recognizer.SRStatisticsCollection;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.recognizer.TimingRepository;
import com.vlingo.sdk.internal.recognizer.XMLResponseListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ASRManager extends SRManager {
    private static final Logger sLog = Logger.getLogger(ASRManager.class);
    private ClientMeta mClientMeta;
    private volatile String mLastGuttId;
    private SRServerDetails mServerDetails;
    private SoftwareMeta mSoftwareMeta;
    private final TimingRepository mTimingRepository;
    private ArrayList<XMLResponseListener> mXMLListeners = null;

    public ASRManager(ConnectionProvider connectionProvider, TimingRepository timings) {
        log("ctor");
        this.mTimingRepository = timings;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void init(SRServerDetails serverDetails, ClientMeta clientMeta, SoftwareMeta softwareMeta) {
        log("init()");
        this.mClientMeta = clientMeta;
        this.mSoftwareMeta = softwareMeta;
        setServer(serverDetails);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void setServer(SRServerDetails serverDetails) {
        log("setServer()");
        this.mServerDetails = serverDetails;
    }

    public SRServerDetails getServerDetails() {
        return this.mServerDetails;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void destroy() {
        log("destroy()");
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public boolean readyForRecognition() {
        return true;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public SRRequest newRequest(SRContext info, SRRequestListener listener) {
        return newRequest(info, listener, true);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public SRRequest newRequest(SRContext info, SRRequestListener listener, boolean sendAudio) {
        log("newRequest()");
        ASRRequest request = new ASRRequest(info, this.mClientMeta, this.mSoftwareMeta, this, this.mTimingRepository, sendAudio);
        if (this.mXMLListeners != null && this.mXMLListeners.size() > 0) {
            Iterator<XMLResponseListener> it = this.mXMLListeners.iterator();
            while (it.hasNext()) {
                XMLResponseListener xmll = it.next();
                request.addXMLResponseListener(xmll);
            }
        }
        request.setConnectTimeout(getConnectTimeout());
        request.setReadTimeout(getReadTimeout());
        request.addListener(listener);
        request.start();
        return request;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void sendStatistics(SRStatistics stats) {
        log("sendStatistics(): queuing stats");
        SRStatisticsCollection collection = new SRStatisticsCollection();
        collection.addStatistics(stats);
        collection.schedule(this.mServerDetails, this.mClientMeta, this.mSoftwareMeta);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void sendStatsCollection(SRStatisticsCollection collection) {
        log("sendStatsCollection(): queueing stats collection");
        collection.schedule(this.mServerDetails, this.mClientMeta, this.mSoftwareMeta);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public String getLastGuttID() {
        return this.mLastGuttId;
    }

    void setLastGuttID(String guttID) {
        this.mLastGuttId = guttID;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void addXMLResponseListener(XMLResponseListener listener) {
        if (this.mXMLListeners == null) {
            this.mXMLListeners = new ArrayList<>();
        }
        this.mXMLListeners.add(listener);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void removeXMLResponseListener(XMLResponseListener listener) {
        if (this.mXMLListeners != null) {
            this.mXMLListeners.remove(listener);
        }
    }

    public HttpURLConnection getConnection(SRContext srContext) throws IOException {
        log("getConnection()");
        return (HttpURLConnection) new URL(this.mServerDetails.getASRURL().url).openConnection();
    }

    private void log(String msg) {
        sLog.debug(msg);
    }
}
