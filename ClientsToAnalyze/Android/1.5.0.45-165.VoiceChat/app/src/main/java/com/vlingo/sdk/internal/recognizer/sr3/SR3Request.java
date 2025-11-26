package com.vlingo.sdk.internal.recognizer.sr3;

import android.util.Log;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.http.BaseHttpCallback;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.cookies.CookieHandler;
import com.vlingo.sdk.internal.http.cookies.CookieJar;
import com.vlingo.sdk.internal.http.custom.MPOutputStream;
import com.vlingo.sdk.internal.http.custom.VHttpConnection;
import com.vlingo.sdk.internal.http.custom.VStreamConnection;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.SRRequest;
import com.vlingo.sdk.internal.recognizer.SRRequestListener;
import com.vlingo.sdk.internal.recognizer.SRServerDetails;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.recognizer.TimingRepository;
import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;
import com.vlingo.sdk.internal.vlservice.VLHttpServiceRequest;
import com.vlingo.sdk.internal.vlservice.VLServiceUtil;
import com.vlingo.sdk.recognition.dialog.VLDialogEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class SR3Request implements SRRequest, Runnable {
    private static final String ATR_ClientRequestID = "ClientRequestID";
    private static final Logger log = Logger.getLogger(SR3Request.class);
    private volatile boolean allAudioReceived;
    private int ivAudioBytesWritten;
    private final ClientMeta ivClientMeta;
    private final SRContext ivContext;
    private HttpConnectionAdapter ivSRCon;
    private final SR3Manager ivSRManager;
    private final SoftwareMeta ivSoftwareMeta;
    private long ivTimeGotResults;
    private long ivTimeSendFinish;
    private long ivTimeSendStart;
    private TimingRepository ivTimings;
    private volatile boolean requestCancelled;
    private boolean requestFinished;
    private volatile Thread requestThread;
    private volatile boolean responseReceived;
    private final boolean sendAudio;
    private boolean sentCancelRequest;
    private volatile boolean startedWritingAudio;
    private final CopyOnWriteArrayList<SRRequestListener> ivListeners = new CopyOnWriteArrayList<>();
    private final CRC32 ivCRC32 = new CRC32();
    private int ivClientRequestID = 0;
    private final Queue<AudioSegment> audioQueue = new ConcurrentLinkedQueue();

    SR3Request(SRContext context, ClientMeta clientMeta, SoftwareMeta softwareMeta, SR3Manager srManager, TimingRepository timings, boolean sendAudio) {
        log("instantiation");
        this.ivContext = context;
        this.ivClientMeta = clientMeta;
        this.ivSoftwareMeta = softwareMeta;
        this.ivSRManager = srManager;
        this.sendAudio = sendAudio;
        this.ivTimings = timings;
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioSegment segment;
        try {
            log.debug("running SR3Request");
            this.requestThread = Thread.currentThread();
            if (!this.requestCancelled) {
                startRequest();
                if (this.sendAudio) {
                    boolean allAudioSent = false;
                    boolean errorOnAudioSend = false;
                    do {
                        synchronized (this) {
                            segment = this.audioQueue.poll();
                            if (segment == null && !this.requestCancelled) {
                                if (this.allAudioReceived) {
                                    allAudioSent = true;
                                } else {
                                    try {
                                        wait();
                                    } catch (InterruptedException e) {
                                    }
                                }
                            }
                        }
                        if (segment != null && !this.requestCancelled) {
                            errorOnAudioSend = !sendAudioSegment(segment);
                        }
                        if (allAudioSent || this.requestCancelled) {
                            break;
                        }
                    } while (!errorOnAudioSend);
                    if (!this.startedWritingAudio && !this.requestCancelled) {
                        this.requestCancelled = true;
                        notifyListeners(-2);
                    }
                    if (this.requestCancelled) {
                        sendCancelRequest();
                        synchronized (this) {
                            closeConnection();
                            this.requestThread = null;
                        }
                        log.debug("End request");
                        return;
                    }
                }
                if (!this.requestCancelled) {
                    finishRequest();
                    if (!this.requestCancelled) {
                        receiveResponse();
                        synchronized (this) {
                            closeConnection();
                            this.requestThread = null;
                        }
                        log.debug("End request");
                        return;
                    }
                }
            }
            synchronized (this) {
                closeConnection();
                this.requestThread = null;
            }
            log.debug("End request");
        } catch (Throwable th) {
            synchronized (this) {
                closeConnection();
                this.requestThread = null;
                log.debug("End request");
                throw th;
            }
        }
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public synchronized void sendAudio(byte[] audio, int offset, int length) {
        log.debug("sendAudio");
        AudioSegment segment = new AudioSegment(audio, offset, length);
        this.audioQueue.add(segment);
        notifyAll();
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public synchronized void finish() {
        log.debug("finish");
        this.allAudioReceived = true;
        notifyAll();
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public synchronized void cancel(boolean timedOut) {
        if (!this.responseReceived) {
            this.requestCancelled = true;
            log.debug("cancel: timedOut=" + timedOut);
            if (timedOut) {
                ConnectionManager.setTimedOut(true);
            }
            if (this.requestThread != null) {
                log.debug("interrupting thread " + this.requestThread.getName());
                try {
                    this.requestThread.interrupt();
                } catch (Exception ex) {
                    log.error("INT", "Execption interrupting worker thread: " + ex.getMessage());
                }
            }
            notifyAll();
        }
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public synchronized boolean isCancelled() {
        return this.requestCancelled;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public synchronized boolean isResponseReceived() {
        return this.responseReceived;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public void addListener(SRRequestListener listener) {
        this.ivListeners.add(listener);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public synchronized void removeListener(SRRequestListener listener) {
        this.ivListeners.remove(listener);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public long getTimeSendStart() {
        return this.ivTimeSendStart;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public long getTimeSendFinish() {
        return this.ivTimeSendFinish;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public long getTimeGotResult() {
        return this.ivTimeGotResults;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bf A[Catch: Exception -> 0x00b2, all -> 0x00f7, Merged into TryCatch #3 {all -> 0x00f7, Exception -> 0x00b2, blocks: (B:3:0x000f, B:4:0x001c, B:14:0x0082, B:35:0x00d6, B:55:0x012b, B:72:0x016b, B:74:0x0175, B:77:0x017c, B:95:0x01bf, B:111:0x0233, B:80:0x0184, B:105:0x01df, B:90:0x01a4, B:65:0x014b, B:45:0x00f6, B:29:0x00b1, B:31:0x00b3), top: B:117:0x000f }, TRY_ENTER, TRY_LEAVE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void startRequest() {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlingo.sdk.internal.recognizer.sr3.SR3Request.startRequest():void");
    }

    private String buildEventElement() {
        StringBuffer sb = new StringBuffer();
        List<VLDialogEvent> eventList = this.ivContext.getEvents();
        if (eventList != null && eventList.size() > 0) {
            sb.append("<Events>");
            for (VLDialogEvent event : eventList) {
                sb.append(event.getXML());
            }
            sb.append("</Events>");
        }
        return sb.toString();
    }

    private String buildMetaElement() {
        StringBuffer sb = new StringBuffer();
        sb.append("<Request ");
        sb.append(HttpUtil.genAtr("FieldID", this.ivContext.getFieldID()));
        sb.append(HttpUtil.genAtr("AppID", this.ivSoftwareMeta.getAppId()));
        sb.append(HttpUtil.genAtr("FieldType", this.ivContext.getFieldType()));
        sb.append(HttpUtil.genAtr("FieldContext", this.ivContext.getFieldContext()));
        String curText = this.ivContext.getCurrentText();
        if (curText.length() > 0) {
            sb.append(HttpUtil.genAtr("CurrentText", curText));
            sb.append(HttpUtil.genAtr("CursorPosition", this.ivContext.getCursorPosition()));
        }
        this.ivContext.logNetworkInfo();
        for (int i = 1; i <= 6; i++) {
            String customValue = this.ivContext.getCustomParam("Custom" + i);
            if (customValue.length() > 0) {
                sb.append(HttpUtil.genAtr("Custom" + i, customValue));
            }
        }
        String streaming = ApplicationAdapter.getInstance().isAudioStreamingEnabled() ? "true" : "false";
        sb.append(HttpUtil.genAtr("StreamingAudio", streaming));
        String autoPunctuate = this.ivContext.getAutoPunctuation() ? "true" : "false";
        sb.append(HttpUtil.genAtr("Punctuate", autoPunctuate));
        String capitalize = this.ivContext.getCapitalization();
        sb.append(HttpUtil.genAtr("Capitalize", capitalize));
        sb.append("/>");
        return sb.toString();
    }

    private void fail(String method, Exception e) {
        log.error(">>>>>>>>>>>>>>" + method + ": Exception: " + e.toString(), Log.getStackTraceString(e));
        if (e instanceof InterruptedIOException) {
            log.warn("setting timedOut to true");
            ConnectionManager.setTimedOut(true);
        }
        log.debug(getTimingString());
        notifyListeners(-1);
        closeConnection();
    }

    private synchronized void closeConnection() {
        if (this.ivSRCon != null) {
            try {
                log.debug("closing connection");
                this.ivSRCon.close();
            } catch (Exception ex) {
                log.debug("Exception closing connection: " + ex.toString());
            }
            this.ivSRCon = null;
        }
    }

    private boolean sendAudioSegment(AudioSegment chunk) {
        log.debug("Begin sendAudioSegment. offset=" + chunk.offset + " length=" + chunk.length);
        try {
            if (this.ivSRCon == null) {
                return false;
            }
            if (chunk.length == 0) {
                log.debug("ignoring zero-length audio segment");
                return true;
            }
            if (!this.startedWritingAudio) {
                this.startedWritingAudio = true;
                this.ivTimeSendStart = System.currentTimeMillis();
                this.ivSRCon.getOut().writeFileFieldHeader(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE, SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                notifyListeners(2);
            }
            MPOutputStream mpOut = this.ivSRCon.getOut();
            mpOut.write(chunk.audio, chunk.offset, chunk.length);
            mpOut.flush();
            recordDetailedTiming("AUD" + chunk.length);
            this.ivAudioBytesWritten += chunk.length;
            this.ivCRC32.update(chunk.audio, chunk.offset, chunk.length);
            return true;
        } catch (Exception e) {
            log.debug("sendAudioSegment: Exception: " + e.getMessage());
            return false;
        } finally {
            log.debug("End sendAudioSegment");
        }
    }

    private synchronized void finishRequest() {
        log.debug("Begin finishRequest");
        if (!this.requestCancelled && this.ivSRCon != null) {
            try {
                try {
                    MPOutputStream mpOut = this.ivSRCon.getOut();
                    if (this.sendAudio) {
                        mpOut.writeEndFieldValue();
                        mpOut.writeBoundary();
                        mpOut.writeField("checksum", "text/crc32", new StringBuilder().append(this.ivCRC32.getValue()).toString());
                        mpOut.flush();
                    }
                    this.ivSRCon.finishRequest();
                    recordDetailedTiming("REQD");
                    this.requestFinished = true;
                    this.ivTimeSendFinish = System.currentTimeMillis();
                } finally {
                    log.debug("End finishRequest");
                }
            } catch (Exception e) {
                log.debug("finishRequest: Exception: " + e.getMessage());
                log.debug("End finishRequest");
            }
        }
    }

    private void receiveResponse() {
        InputStream in;
        SRRecognitionResponse response;
        log.debug("** Begin receiveResponse");
        if (this.requestCancelled) {
            return;
        }
        try {
            if (this.ivSRCon == null) {
                return;
            }
            synchronized (this) {
                VHttpConnection vHttp = this.ivSRCon.getConnection();
                VStreamConnection vCon = vHttp.getVStreamConnection();
                vCon.startResponse(vHttp.getHttpInteraction().getResponse());
            }
            if (this.requestCancelled) {
                return;
            }
            synchronized (this) {
                notifyListeners(3);
                recordDetailedTiming("RESP");
                in = this.ivSRCon.getIn();
                recordDetailedTiming("RESH");
            }
            if (this.requestCancelled) {
                return;
            }
            synchronized (this) {
                byte[] httpResponse = HttpUtil.readData(in);
                this.ivTimeGotResults = System.currentTimeMillis();
                CookieJar responseCookies = CookieHandler.extractCookies(this.ivSRCon);
                VLServiceUtil.handleResponseCookies(responseCookies);
                String responseXML = new String(httpResponse, "UTF-8");
                response = this.ivSRManager.getResponseParser().parseResponseXml(responseXML);
                log.debug("** Response:" + response);
                this.responseReceived = true;
            }
            if (!this.requestCancelled) {
                this.ivSRManager.setLastGuttID(response.getGUttId());
                notifyListeners(response);
                if (this.ivSRCon != null) {
                    this.ivSRCon.finishResponse();
                    log.debug("setting timedOut to false");
                    ConnectionManager.setTimedOut(false);
                }
            }
        } catch (Exception e) {
            fail("receiveResponse", e);
        } finally {
            log.debug("** End receiveResponse, " + getTimingString());
        }
    }

    private void sendCancelRequest() {
        log.debug("** Begin sendCancelRequest");
        if (this.ivSRCon != null) {
            if (this.requestFinished) {
                if (!this.sentCancelRequest) {
                    SRServerDetails serverDetails = this.ivSRManager.getServerDetails();
                    StringBuffer data = new StringBuffer();
                    data.append("<Cancel ");
                    data.append(HttpUtil.genAtr(ATR_ClientRequestID, new StringBuilder().append(this.ivClientRequestID).toString()));
                    data.append("/>");
                    VLHttpServiceRequest request = VLHttpServiceRequest.createVLRequest("SRCancel", new BaseHttpCallback(), serverDetails.getASRCancelURL(), data.toString());
                    request.setClientMeta(this.ivClientMeta);
                    request.setSoftwareMeta(this.ivSoftwareMeta);
                    request.schedule(0L, true, false);
                    this.sentCancelRequest = true;
                }
            } else {
                try {
                    synchronized (this) {
                        if (this.ivSRCon != null) {
                            MPOutputStream mpOut = this.ivSRCon.getOut();
                            if (this.startedWritingAudio) {
                                mpOut.writeEndFieldValue();
                                mpOut.writeBoundary();
                                mpOut.writeField("checksum", "text/crc32", new StringBuilder().append(this.ivCRC32.getValue()).toString());
                            }
                            mpOut.writeField("cancel", VLHttpServiceRequest.RESPONSE_ENCODING_XML, "<cancel/>");
                            mpOut.flush();
                            this.ivSRCon.finishRequest();
                            this.requestFinished = true;
                            try {
                                byte[] httpResponse = HttpUtil.readData(this.ivSRCon.getIn());
                                log.debug("** read cancel response: " + (httpResponse == null ? "" : new String(httpResponse, "UTF-8")));
                            } catch (IOException e) {
                            }
                            this.ivSRCon.finishResponse();
                        } else {
                            return;
                        }
                    }
                } catch (Exception ex) {
                    log.debug(">>>>>>>>>>>>>>sendCancelRequest: Exception:" + ex);
                    ex.printStackTrace();
                    closeConnection();
                }
            }
            log.debug("** End sendCancelRequest, " + getTimingString());
        }
    }

    private void notifyListeners(SRRecognitionResponse result) {
        Iterator<SRRequestListener> it = this.ivListeners.iterator();
        while (it.hasNext()) {
            SRRequestListener ivListener = it.next();
            ivListener.resultReceived(result);
        }
    }

    private void notifyListeners(int state) {
        Iterator<SRRequestListener> it = this.ivListeners.iterator();
        while (it.hasNext()) {
            SRRequestListener ivListener = it.next();
            if (isErrorState(state)) {
                ivListener.requestFailed(state);
            } else {
                ivListener.stateChanged(state);
            }
        }
    }

    private boolean isErrorState(int state) {
        return state < 0;
    }

    private void recordDetailedTiming(String event) {
        if (this.ivTimings != null) {
            this.ivTimings.recordAndTimeStampEvent(event);
        }
    }

    private static class AudioSegment {
        byte[] audio;
        int length;
        int offset;

        AudioSegment(byte[] audio, int offset, int length) {
            this.audio = audio;
            this.offset = offset;
            this.length = length;
        }
    }

    private String getTimingString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);
        StringBuffer buf = new StringBuffer();
        try {
            buf.append("Timing Data:\n\tSend start:\t\t\t\t" + sdf.format(new Date(this.ivTimeSendStart)));
            buf.append("\n\tSend finish:\t\t\t" + sdf.format(new Date(this.ivTimeSendFinish)));
            buf.append("\n\tTime got results:\t\t" + sdf.format(new Date(this.ivTimeGotResults)));
            buf.append("\n\tAudio bytes written:\t" + this.ivAudioBytesWritten);
        } catch (Exception e) {
            log.error(getClass().getCanonicalName(), Log.getStackTraceString(e));
        }
        return buf.toString();
    }

    private void log(String msg) {
        log.debug(msg);
    }
}
