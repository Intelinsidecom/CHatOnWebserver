package com.vlingo.sdk.internal.recognizer.sr3;

import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.http.custom.VHttpConnection;
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
import com.vlingo.sdk.internal.recognizer.results.SRResponseParser;
import com.vlingo.sdk.internal.util.ThreadPoolExecutor;
import java.io.IOException;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class SR3Manager extends SRManager {
    private static final Logger log = Logger.getLogger(SR3Manager.class);
    private final ConnectionProvider connectionProvider;
    private ClientMeta ivClientMeta;
    private VHttpConnection ivCon;
    private volatile String ivLastGuttID;
    private SoftwareMeta ivSoftwareMeta;
    SRServerDetails serverDetails;
    private final TimingRepository timings;
    private final ThreadPoolExecutor ivExecutor = new ThreadPoolExecutor("SR3Worker");
    private int ivRequestId = 1;
    private final SRResponseParser responseParser = new SRResponseParser();

    public SR3Manager(ConnectionProvider connectionProvider, TimingRepository timings) {
        this.connectionProvider = connectionProvider;
        this.timings = timings;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void init(SRServerDetails serverDetails, ClientMeta clientMeta, SoftwareMeta softwareMeta) {
        this.ivClientMeta = clientMeta;
        this.ivSoftwareMeta = softwareMeta;
        setServer(serverDetails);
        this.ivExecutor.setMaxPoolSize(8);
    }

    public SRResponseParser getResponseParser() {
        return this.responseParser;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void setServer(SRServerDetails serverDetails) {
        this.serverDetails = serverDetails;
    }

    public SRServerDetails getServerDetails() {
        return this.serverDetails;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void destroy() {
        this.ivExecutor.shutdown();
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public boolean readyForRecognition() {
        return !this.ivExecutor.isBusy();
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public SRRequest newRequest(SRContext context, SRRequestListener listener) {
        return newRequest(context, listener, true);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public SRRequest newRequest(SRContext context, SRRequestListener listener, boolean sendAudio) throws Throwable {
        SR3Request request = new SR3Request(context, this.ivClientMeta, this.ivSoftwareMeta, this, this.timings, sendAudio);
        request.addListener(listener);
        log.info("Queuing new request");
        this.ivExecutor.execute(request);
        return request;
    }

    public HttpConnectionAdapter getConnection(SRContext srContext) throws IOException {
        log.info(" in getConnection");
        if (ApplicationAdapter.getInstance().isAudioStreamingEnabled()) {
            return getChunkingConnection(srContext);
        }
        ConnectionProvider connectionProvider = this.connectionProvider;
        String str = this.serverDetails.getASRURL().url;
        ClientMeta clientMeta = this.ivClientMeta;
        SoftwareMeta softwareMeta = this.ivSoftwareMeta;
        int i = this.ivRequestId;
        this.ivRequestId = i + 1;
        return StandardHttpConnection.newConnection(connectionProvider, HttpUtil.METHOD_POST, str, clientMeta, softwareMeta, null, i, srContext);
    }

    private ChunkingHttpConnection getChunkingConnection(SRContext srContext) throws IOException {
        log.debug("keep-alive: false");
        ConnectionProvider connectionProvider = this.connectionProvider;
        URL asrurl = this.serverDetails.getASRURL();
        ClientMeta clientMeta = this.ivClientMeta;
        SoftwareMeta softwareMeta = this.ivSoftwareMeta;
        int i = this.ivRequestId;
        this.ivRequestId = i + 1;
        return ChunkingHttpConnection.newConnection(connectionProvider, HttpUtil.METHOD_POST, asrurl, clientMeta, softwareMeta, (Hashtable<String, String>) null, i, srContext);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void sendStatistics(SRStatistics stats) {
        log.debug("Queuing stats");
        SRStatisticsCollection collection = new SRStatisticsCollection();
        collection.addStatistics(stats);
        collection.schedule(this.serverDetails, this.ivClientMeta, this.ivSoftwareMeta);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void sendStatsCollection(SRStatisticsCollection collection) {
        log.debug("Queueing stats collection");
        collection.schedule(this.serverDetails, this.ivClientMeta, this.ivSoftwareMeta);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public String getLastGuttID() {
        return this.ivLastGuttID;
    }

    void setLastGuttID(String guttID) {
        this.ivLastGuttID = guttID;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void addXMLResponseListener(XMLResponseListener listener) {
        this.responseParser.addXMLResponseListener(listener);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRManager
    public void removeXMLResponseListener(XMLResponseListener listener) {
        this.responseParser.removeXMLResponseListener(listener);
    }
}
