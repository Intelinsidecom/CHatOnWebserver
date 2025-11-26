package com.vlingo.sdk.internal.recognizer.asr;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.cookies.CookieHandler;
import com.vlingo.sdk.internal.http.custom.MPOutputStream;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.SRRequest;
import com.vlingo.sdk.internal.recognizer.SRRequestListener;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.recognizer.TimingRepository;
import com.vlingo.sdk.internal.recognizer.XMLResponseListener;
import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;
import com.vlingo.sdk.internal.recognizer.results.SRResponseParser;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.vlservice.VLHttpServiceRequest;
import com.vlingo.sdk.internal.vlservice.VLServiceUtil;
import com.vlingo.sdk.recognition.AudioSourceInfo;
import com.vlingo.sdk.recognition.dialog.VLDialogEvent;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class ASRRequest implements SRRequest {
    public static final String BOUNDRY = "-------------------------------1878979834";
    private static final int HTTP_CHUNK_SIZE = 512;
    private static Logger log = Logger.getLogger(ASRRequest.class);
    private boolean isExpectingAudio;
    private boolean isFinished;
    private AudioOutputStream mAudioOutputStream;
    private final ClientMeta mClientMeta;
    private Handler mHandler;
    private HandlerThread mNetworkThread;
    private final SRContext mSRContext;
    private final ASRManager mSRManager;
    private final SoftwareMeta mSoftwareMeta;
    private long mTimeGotResults;
    private long mTimeSendFinish;
    private long mTimeSendStart;
    private TimingRepository mTimings;
    private ArrayList<XMLResponseListener> mXMLListeners = null;
    private final CopyOnWriteArrayList<SRRequestListener> mListeners = new CopyOnWriteArrayList<>();
    private int mConnectTimeout = -1;
    private int mReadTimeout = -1;
    private int mRequestId = 1;
    private final CRC32 mCRC32 = new CRC32();
    private final Timer mTimeoutTimer = new Timer("ASRRequest:TimeoutTimer");
    private final BlockingQueue<AudioSegment> mAudioQueue = new LinkedBlockingQueue();
    private HttpURLConnection mConnection = null;
    private MPOutputStream mMPOutputStream = null;
    private SRRecognitionResponse mResponse = null;
    private State mDisconnectedState = new DisconnectedState(this, null);
    private State mStreamingState = new StreamingState(this, 0 == true ? 1 : 0);
    private State mFinishedState = new FinishedState(this, 0 == true ? 1 : 0);
    private State mReceivingState = new ReceivingState(this, 0 == true ? 1 : 0);
    private State mReceivedState = new ReceivedState(this, 0 == true ? 1 : 0);
    private State mCancelledState = new CancelledState(this, 0 == true ? 1 : 0);
    private State mState = this.mDisconnectedState;

    ASRRequest(SRContext sRContext, ClientMeta clientMeta, SoftwareMeta softwareMeta, ASRManager aSRManager, TimingRepository timingRepository, boolean z) {
        AudioOutputStream noAudioOutputStream;
        byte b = 0;
        this.mAudioOutputStream = null;
        log("ctor(): " + (z ? "with" : "without") + " audio stream");
        this.mSRContext = sRContext;
        this.mClientMeta = clientMeta;
        this.mSoftwareMeta = softwareMeta;
        this.mSRManager = aSRManager;
        this.isExpectingAudio = z;
        this.mTimings = timingRepository;
        this.mDisconnectedState.transitionTo(this.mStreamingState);
        this.mStreamingState.transitionTo(this.mFinishedState);
        this.mFinishedState.transitionTo(this.mReceivingState);
        this.mReceivingState.transitionTo(this.mReceivedState);
        this.mReceivedState.noTransition();
        this.mCancelledState.noTransition();
        if (z) {
            noAudioOutputStream = new AudioOutputStream();
        } else {
            noAudioOutputStream = new NoAudioOutputStream(this, b == true ? 1 : 0);
        }
        this.mAudioOutputStream = noAudioOutputStream;
    }

    public int getConnectTimeout() {
        int optimalConnectTimeout = this.mConnectTimeout == -1 ? ConnectionManager.getOptimalConnectTimeout() : this.mConnectTimeout;
        this.mConnectTimeout = optimalConnectTimeout;
        return optimalConnectTimeout;
    }

    public int getReadTimeout() {
        int optimalConnectTimeout = this.mReadTimeout == -1 ? ConnectionManager.getOptimalConnectTimeout() : this.mReadTimeout;
        this.mReadTimeout = optimalConnectTimeout;
        return optimalConnectTimeout;
    }

    public ASRRequest setConnectTimeout(int timeout) {
        this.mConnectTimeout = timeout;
        return this;
    }

    public ASRRequest setReadTimeout(int timeout) {
        this.mReadTimeout = timeout;
        return this;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public void sendAudio(byte[] audio, int offset, int length) {
        getState().sendAudio(audio, offset, length);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public void finish() {
        getState().finish();
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public void cancel(boolean timedOut) {
        getState().cancel(timedOut);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public boolean isCancelled() {
        return getState().isCancelled();
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public boolean isResponseReceived() {
        return getState().isResponseReceived();
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public void addListener(SRRequestListener listener) {
        this.mListeners.add(listener);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public void removeListener(SRRequestListener listener) {
        this.mListeners.remove(listener);
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public long getTimeSendStart() {
        return this.mTimeSendStart;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public long getTimeSendFinish() {
        return this.mTimeSendFinish;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRRequest
    public long getTimeGotResult() {
        return this.mTimeGotResults;
    }

    public void start() {
        log("start()");
        this.mNetworkThread = new HandlerThread("ASRRequest:NetworkThread" + this.mRequestId);
        this.mNetworkThread.start();
        this.mHandler = new Handler(this.mNetworkThread.getLooper());
        runCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        log("stop(): background processing halted");
        this.mNetworkThread.quit();
        this.mTimeoutTimer.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimeoutTimer() {
        log("starting timeout timer [" + getReadTimeout() + " ms]");
        TimerTask task = new TimerTask() { // from class: com.vlingo.sdk.internal.recognizer.asr.ASRRequest.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ASRRequest.this.onTimeout(-3);
            }
        };
        this.mTimeoutTimer.schedule(task, getReadTimeout());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeout(int reason) {
        log("onTimeout()");
        ConnectionManager.setTimedOut(true);
        cancel(true);
        notifyListeners(reason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int reason) {
        cancel(false);
        notifyListeners(reason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(SRRecognitionResponse result) {
        Iterator<SRRequestListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            SRRequestListener ivListener = it.next();
            ivListener.resultReceived(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(int state) {
        Iterator<SRRequestListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            SRRequestListener ivListener = it.next();
            if (isErrorState(state)) {
                ivListener.requestFailed(state);
            } else {
                ivListener.stateChanged(state);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildEventElement() {
        StringBuffer sb = new StringBuffer();
        List<VLDialogEvent> eventList = getRequestContext().getEvents();
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
        String capitalize = getRequestContext().getCapitalization();
        String autoPunctuate = getRequestContext().getAutoPunctuation() ? "true" : "false";
        String streaming = ApplicationAdapter.getInstance().isAudioStreamingEnabled() ? "true" : "false";
        getRequestContext().logNetworkInfo();
        String curText = getRequestContext().getCurrentText();
        StringBuffer sb = new StringBuffer();
        sb.append("<Request ");
        sb.append(HttpUtil.genAtr("FieldID", getRequestContext().getFieldID()));
        sb.append(HttpUtil.genAtr("AppID", this.mSoftwareMeta.getAppId()));
        sb.append(HttpUtil.genAtr("FieldType", getRequestContext().getFieldType()));
        sb.append(HttpUtil.genAtr("FieldContext", getRequestContext().getFieldContext()));
        if (curText.length() > 0) {
            sb.append(HttpUtil.genAtr("CurrentText", curText));
            sb.append(HttpUtil.genAtr("CursorPosition", getRequestContext().getCursorPosition()));
        }
        for (int i = 1; i <= 6; i++) {
            String customValue = getRequestContext().getCustomParam("Custom" + i);
            if (customValue.length() > 0) {
                sb.append(HttpUtil.genAtr("Custom" + i, customValue));
            }
        }
        sb.append(HttpUtil.genAtr("StreamingAudio", streaming));
        sb.append(HttpUtil.genAtr("Punctuate", autoPunctuate));
        sb.append(HttpUtil.genAtr("Capitalize", capitalize));
        sb.append("/>");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertMetaTag(MPOutputStream out) throws IOException {
        out.writeField("meta", VLHttpServiceRequest.RESPONSE_ENCODING_XML, buildMetaElement());
        out.flush();
        recordDetailedTiming("META");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertTextTag(MPOutputStream out) throws IOException {
        out.writeField("text", "text/plain; charset=utf-8", getRequestContext().getAudioSourceInfo().getText());
        out.flush();
        recordDetailedTiming("TEXT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertCRCTag(MPOutputStream out) throws IOException {
        out.writeField("checksum", "text/crc32", new StringBuilder().append(this.mCRC32.getValue()).toString());
        out.flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordDetailedTiming(String event) {
        if (this.mTimings != null) {
            this.mTimings.recordAndTimeStampEvent(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTimingString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);
        StringBuffer buf = new StringBuffer();
        try {
            buf.append("Timing Data:\n\tSend start:\t\t\t\t").append(sdf.format(new Date(getTimeSendStart()))).append("\n\tSend finish:\t\t\t").append(sdf.format(new Date(getTimeSendFinish()))).append("\n\tTime got results:\t\t").append(sdf.format(new Date(getTimeGotResult()))).append("\n\tAudio bytes written:\t").append(getAudioOutputStream().getBytesWritten());
        } catch (Exception e) {
            log.error(getClass().getCanonicalName(), Log.getStackTraceString(e));
        }
        return buf.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runCurrentState() {
        this.mHandler.post(getState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(State state) {
        log("setState(" + state + ")");
        this.mState = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public State getState() {
        return this.mState;
    }

    private boolean isErrorState(int state) {
        return state < 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isExpectingAudio() {
        return this.isExpectingAudio;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SRContext getRequestContext() {
        return this.mSRContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ASRManager getRequestManager() {
        return this.mSRManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SoftwareMeta getSoftwareData() {
        return this.mSoftwareMeta;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClientMeta getClientData() {
        return this.mClientMeta;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BlockingQueue<AudioSegment> getAudioQueue() {
        return this.mAudioQueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection getConnection() {
        return this.mConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MPOutputStream getOutputStream() {
        return this.mMPOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AudioOutputStream getAudioOutputStream() {
        return this.mAudioOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SRRecognitionResponse getResponse() {
        return this.mResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnection(HttpURLConnection connection) {
        this.mConnection = connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputStream(MPOutputStream out) {
        this.mMPOutputStream = out;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponse(SRRecognitionResponse response) {
        this.mResponse = response;
        getRequestManager().setLastGuttID(response.getGUttId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] consume(InputStream in) throws IOException {
        byte[] buffer = new byte[256];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (true) {
            int bytesRead = getConnection().getInputStream().read(buffer);
            if (bytesRead >= 0) {
                out.write(buffer, 0, bytesRead);
            } else {
                return out.toByteArray();
            }
        }
    }

    private static class Connection {
        private Connection() {
        }

        public static String describe(HttpURLConnection connection) {
            return connection.getClass().getSimpleName() + "(" + quoted(connection.getURL()) + "," + connection.getConnectTimeout() + "," + connection.getReadTimeout() + ")";
        }

        public static String quoted(Object msg) {
            return "\"" + msg.toString() + "\"";
        }
    }

    private static class AudioSegment {
        byte[] audio;
        boolean endSegment;
        int length;
        int offset;

        AudioSegment(byte[] audio, int offset, int length) {
            this.audio = audio;
            this.offset = offset;
            this.length = length;
        }

        public String toString() {
            return getClass().getSimpleName() + "(" + this.offset + "," + (this.offset + this.length) + ") [" + this.length + " bytes]";
        }

        public void setEndSegment() {
            this.endSegment = true;
        }

        public boolean isEndSegment() {
            return this.endSegment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(State state, String msg) {
        log.debug("[" + state.getClass().getSimpleName() + "] " + msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(Throwable t) {
        log("EXCEPTION: " + t.toString() + "\n" + Log.getStackTraceString(t));
    }

    private void log(String msg) {
        log(getState(), msg);
    }

    private class AudioOutputStream {
        private int mAudioBytesWritten;
        private MPOutputStream out;
        private boolean flushOnWrite = false;
        private boolean mIsOpen = false;
        private Boolean mAudioTagSent = false;

        public AudioOutputStream() {
        }

        public boolean isOpen() {
            return this.mIsOpen;
        }

        public AudioOutputStream open(MPOutputStream out) throws IOException, NullPointerException {
            if (out == null) {
                throw new NullPointerException("you MUST provide an output stream");
            }
            this.out = out;
            ASRRequest.this.insertMetaTag(out);
            flush();
            this.mIsOpen = true;
            return this;
        }

        public AudioOutputStream setFlushOnWrite(boolean flushOnWrite) {
            this.flushOnWrite = flushOnWrite;
            return this;
        }

        public AudioOutputStream write(byte[] audio, int offset, int length) throws IOException {
            if (length > 0) {
                insertAudioTag();
                this.out.write(audio, offset, length);
                ASRRequest.this.recordDetailedTiming("AUD" + length);
                this.mAudioBytesWritten += length;
                ASRRequest.this.mCRC32.update(audio, offset, length);
                if (this.flushOnWrite) {
                    flush();
                }
            }
            return this;
        }

        public AudioOutputStream flush() throws IOException {
            this.out.flush();
            return this;
        }

        public AudioOutputStream close() throws IOException {
            this.mIsOpen = false;
            this.out.writeEndFieldValue();
            this.out.writeBoundary();
            ASRRequest.this.insertCRCTag(this.out);
            ASRRequest.this.recordDetailedTiming("REQD");
            return this;
        }

        public int getBytesWritten() {
            return this.mAudioBytesWritten;
        }

        private void insertAudioTag() throws IOException {
            if (!this.mAudioTagSent.booleanValue()) {
                this.mAudioTagSent = true;
                ASRRequest.this.mTimeSendStart = System.currentTimeMillis();
                ASRRequest.this.notifyListeners(2);
                this.out.writeFileFieldHeader(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE, SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
        }
    }

    private class NoAudioOutputStream extends AudioOutputStream {
        private NoAudioOutputStream() {
            super();
        }

        /* synthetic */ NoAudioOutputStream(ASRRequest aSRRequest, NoAudioOutputStream noAudioOutputStream) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.AudioOutputStream
        public AudioOutputStream open(MPOutputStream out) {
            return this;
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.AudioOutputStream
        public AudioOutputStream write(byte[] audio, int offset, int length) {
            return this;
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.AudioOutputStream
        public AudioOutputStream flush() {
            return this;
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.AudioOutputStream
        public AudioOutputStream close() {
            return this;
        }
    }

    private class State implements Runnable {
        private State mNextState;

        private State() {
        }

        /* synthetic */ State(ASRRequest aSRRequest, State state) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                onRun();
            } catch (Throwable th) {
                ASRRequest.this.onError(-2);
            }
            transition();
        }

        public boolean endAudio() {
            AudioSegment segment = new AudioSegment(null, 0, 0);
            segment.setEndSegment();
            log("endAudio(): queuing end-of-audio segment");
            boolean success = ASRRequest.this.getAudioQueue().offer(segment);
            if (!success) {
                log("Unable to add end-of-audio AudioSegment to audio queue (queue full?)");
            }
            return success;
        }

        public void sendAudio(byte[] audio, int offset, int length) {
            AudioSegment segment = new AudioSegment(audio, offset, length);
            log("sendAudio(): queuing " + segment);
            if (!ASRRequest.this.getAudioQueue().offer(segment)) {
                log("Unable to add AudioSegment to audio queue (queue full?)");
                ASRRequest.this.onError(-2);
            }
        }

        public void finish() {
            log("finish()");
            if (!ASRRequest.this.isFinished) {
                ASRRequest.this.isFinished = true;
                ASRRequest.this.startTimeoutTimer();
                if (!endAudio()) {
                    ASRRequest.this.onError(-2);
                }
            }
        }

        public void cancel(boolean timedOut) {
            log("cancel(): " + (timedOut ? "due" : "not due") + " to timeout");
            setState(ASRRequest.this.mCancelledState);
            endAudio();
        }

        public boolean isCancelled() {
            return false;
        }

        public boolean isResponseReceived() {
            return false;
        }

        public void transitionTo(State state) {
            this.mNextState = state;
        }

        public void noTransition() {
            this.mNextState = null;
        }

        public String toString() {
            return getClass().getSimpleName();
        }

        protected void onRun() throws IOException {
        }

        protected boolean hasTransition() {
            return this.mNextState != null;
        }

        protected void transition() {
            if (hasTransition()) {
                ASRRequest.this.getState().setState(this.mNextState);
                ASRRequest.this.runCurrentState();
            }
        }

        protected void setState(State state) {
            ASRRequest.this.changeState(state);
        }

        protected void log(Throwable t) {
            ASRRequest.this.log(t);
        }

        protected void log(String msg) {
            ASRRequest.this.log(this, msg);
        }
    }

    private class DisconnectedState extends State {
        private DisconnectedState() {
            super(ASRRequest.this, null);
        }

        /* synthetic */ DisconnectedState(ASRRequest aSRRequest, DisconnectedState disconnectedState) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void onRun() throws Throwable {
            log("connecting ...");
            ASRRequest.this.recordDetailedTiming("RUN");
            ASRRequest.this.notifyListeners(1);
            ASRRequest.this.setConnection(ASRRequest.this.getRequestManager().getConnection(ASRRequest.this.getRequestContext()));
            ASRRequest.this.recordDetailedTiming("OPEN");
            ASRRequest.this.getConnection().setDoInput(true);
            ASRRequest.this.getConnection().setDoOutput(true);
            ASRRequest.this.getConnection().setUseCaches(false);
            ASRRequest.this.getConnection().setReadTimeout(ASRRequest.this.getReadTimeout());
            ASRRequest.this.getConnection().setConnectTimeout(ASRRequest.this.getConnectTimeout());
            HttpURLConnection connection = ASRRequest.this.getConnection();
            StringBuilder sb = new StringBuilder("ClientRequestID:");
            ASRRequest aSRRequest = ASRRequest.this;
            int i = aSRRequest.mRequestId;
            aSRRequest.mRequestId = i + 1;
            connection.setRequestProperty("X-vlrequest", sb.append(i).toString());
            Hashtable<String, String> headers = new Hashtable<>();
            Hashtable<String, String> cookies = new Hashtable<>();
            VLServiceUtil.addStandardVlingoHttpHeaders(headers, ASRRequest.this.getClientData(), ASRRequest.this.getSoftwareData(), ASRRequest.this.getRequestContext());
            VLServiceUtil.addVLServiceCookies(cookies, ASRRequest.this.getConnection().getURL().getHost(), ASRRequest.this.getConnection().getURL().getPath());
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                ASRRequest.this.getConnection().setRequestProperty(entry.getKey(), entry.getValue());
            }
            String cookieStr = HttpUtil.getCookies(cookies);
            if (cookieStr.length() > 0) {
                ASRRequest.this.getConnection().setRequestProperty(HttpUtil.HEADER_COOKIE, cookieStr);
            }
            ASRRequest.this.getConnection().setChunkedStreamingMode(512);
            ASRRequest.this.recordDetailedTiming("HDRS");
            log("connecting to " + Connection.describe(ASRRequest.this.getConnection()));
            try {
                ASRRequest.this.setOutputStream(new MPOutputStream(new DataOutputStream(ASRRequest.this.getConnection().getOutputStream()), ASRRequest.BOUNDRY));
                ASRRequest.this.getOutputStream().writeBoundary();
                List<VLDialogEvent> events = ASRRequest.this.getRequestContext().getEvents();
                if (events != null && events.size() > 0) {
                    String event = ASRRequest.this.buildEventElement();
                    ASRRequest.this.getOutputStream().writeDataField("events", VLHttpServiceRequest.RESPONSE_ENCODING_XML, StringUtils.convertStringToBytes(event), true);
                    ASRRequest.this.getOutputStream().flush();
                    ASRRequest.this.recordDetailedTiming("DMEV");
                }
                byte[] data = ASRRequest.this.getRequestContext().getDialogState();
                if (data != null && data.length > 0) {
                    ASRRequest.this.getOutputStream().writeDataField("dialog-data", "binary", data);
                    ASRRequest.this.getOutputStream().flush();
                    ASRRequest.this.recordDetailedTiming("DMST");
                }
                AudioSourceInfo asi = ASRRequest.this.getRequestContext().getAudioSourceInfo();
                if (asi != null && asi.isString()) {
                    ASRRequest.this.mCRC32.update(asi.getText().getBytes());
                    ASRRequest.this.insertMetaTag(ASRRequest.this.getOutputStream());
                    ASRRequest.this.insertTextTag(ASRRequest.this.getOutputStream());
                    ASRRequest.this.insertCRCTag(ASRRequest.this.getOutputStream());
                } else {
                    ASRRequest.this.getAudioOutputStream().open(ASRRequest.this.getOutputStream()).setFlushOnWrite(true);
                }
                log("connected");
            } catch (SocketTimeoutException e) {
                log("connection TIMED OUT");
                ASRRequest.this.onTimeout(-1);
            } catch (IOException e2) {
                log("connection FAILED: " + e2);
                ASRRequest.this.onError(-1);
            }
        }
    }

    private class StreamingState extends State {
        private StreamingState() {
            super(ASRRequest.this, null);
        }

        /* synthetic */ StreamingState(ASRRequest aSRRequest, StreamingState streamingState) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void onRun() throws IOException {
            if (ASRRequest.this.isExpectingAudio()) {
                while (!ASRRequest.this.getState().isCancelled()) {
                    try {
                        AudioSegment audioSegment = (AudioSegment) ASRRequest.this.getAudioQueue().take();
                        if (!audioSegment.isEndSegment()) {
                            log("streaming " + audioSegment);
                            ASRRequest.this.getAudioOutputStream().write(audioSegment.audio, audioSegment.offset, audioSegment.length);
                        } else {
                            return;
                        }
                    } catch (SocketTimeoutException e) {
                        log("streaming TIMED OUT");
                        ASRRequest.this.onTimeout(-3);
                        return;
                    } catch (IOException e2) {
                        log(e2);
                        ASRRequest.this.onError(-2);
                        return;
                    } catch (InterruptedException e3) {
                        log(e3);
                        ASRRequest.this.onError(-2);
                        return;
                    }
                }
                return;
            }
            log("no audio excpected, transitioning ...");
        }
    }

    private class FinishedState extends State {
        private FinishedState() {
            super(ASRRequest.this, null);
        }

        /* synthetic */ FinishedState(ASRRequest aSRRequest, FinishedState finishedState) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void sendAudio(byte[] audio, int offset, int length) {
            log("sendAudio(): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void finish() {
            log("finish(): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void onRun() throws IOException {
            log("audio stream complete");
            ASRRequest.this.getAudioOutputStream().close();
        }
    }

    private class ReceivingState extends State {
        private ReceivingState() {
            super(ASRRequest.this, null);
        }

        /* synthetic */ ReceivingState(ASRRequest aSRRequest, ReceivingState receivingState) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void sendAudio(byte[] audio, int offset, int length) {
            log("sendAudio()");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void onRun() throws IOException {
            log("receiving ...");
            ASRRequest.this.notifyListeners(3);
            ASRRequest.this.recordDetailedTiming("RESP");
            ASRRequest.this.recordDetailedTiming("RESH");
            try {
                ASRRequest.this.mTimeGotResults = System.currentTimeMillis();
                VLServiceUtil.handleResponseCookies(CookieHandler.extractCookies(ASRRequest.this.getConnection()));
                SRResponseParser parser = new SRResponseParser();
                if (ASRRequest.this.mXMLListeners != null && ASRRequest.this.mXMLListeners.size() > 0) {
                    Iterator it = ASRRequest.this.mXMLListeners.iterator();
                    while (it.hasNext()) {
                        XMLResponseListener xmll = (XMLResponseListener) it.next();
                        parser.addXMLResponseListener(xmll);
                    }
                }
                ASRRequest.this.setResponse(parser.parseResponseXml(new String(ASRRequest.this.consume(ASRRequest.this.getConnection().getInputStream()), "UTF-8")));
            } catch (SocketTimeoutException e) {
                log("response TIMED OUT");
                ASRRequest.this.onTimeout(-3);
            } catch (IOException e2) {
                log(e2);
                ASRRequest.this.onError(-2);
            }
        }
    }

    private class ReceivedState extends State {
        private ReceivedState() {
            super(ASRRequest.this, null);
        }

        /* synthetic */ ReceivedState(ASRRequest aSRRequest, ReceivedState receivedState) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public boolean isResponseReceived() {
            return true;
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void sendAudio(byte[] audio, int offset, int length) {
            log("sendAudio(): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void finish() {
            log("finish(): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void cancel(boolean timedOut) {
            log("cancel(): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void setState(State state) {
            log("setState(" + state + "): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void onRun() throws IOException {
            ASRRequest.this.stop();
            log("response = " + ASRRequest.this.getResponse());
            ConnectionManager.setTimedOut(false);
            log("closing connection");
            ASRRequest.this.getOutputStream().close();
            ASRRequest.this.getConnection().disconnect();
            ASRRequest.this.notifyListeners(ASRRequest.this.getResponse());
            log("done at " + ASRRequest.this.getTimingString());
        }
    }

    private class CancelledState extends State {
        private CancelledState() {
            super(ASRRequest.this, null);
        }

        /* synthetic */ CancelledState(ASRRequest aSRRequest, CancelledState cancelledState) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public boolean isCancelled() {
            return true;
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public boolean endAudio() {
            log("endAudio(): ignored");
            return true;
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void sendAudio(byte[] audio, int offset, int length) {
            log("sendAudio(): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void finish() {
            log("finish(): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void cancel(boolean timedOut) {
            log("cancel(): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void setState(State state) {
            log("setState(" + state + "): ignored");
        }

        @Override // com.vlingo.sdk.internal.recognizer.asr.ASRRequest.State
        public void onRun() throws IOException {
            ASRRequest.this.stop();
            log("clearing queue");
            ASRRequest.this.getAudioQueue().clear();
            if (ASRRequest.this.getAudioOutputStream().isOpen()) {
                log("sending cancellation to server ...");
                ASRRequest.this.getAudioOutputStream().close();
                ASRRequest.this.getOutputStream().writeField("cancel", VLHttpServiceRequest.RESPONSE_ENCODING_XML, "<cancel/>");
                ASRRequest.this.getOutputStream().flush();
                ASRRequest.this.getOutputStream().close();
                try {
                    byte[] httpResponse = ASRRequest.this.consume(ASRRequest.this.getConnection().getInputStream());
                    log("cancel response = " + (httpResponse == null ? "" : new String(httpResponse, "UTF-8")));
                } catch (IOException e) {
                    log(e);
                } finally {
                    ASRRequest.this.getConnection().disconnect();
                }
            }
            log("cancel complete @ " + ASRRequest.this.getTimingString());
        }
    }

    public void addXMLResponseListener(XMLResponseListener listener) {
        if (this.mXMLListeners == null) {
            this.mXMLListeners = new ArrayList<>();
        }
        this.mXMLListeners.add(listener);
    }

    public void removeXMLResponseListener(XMLResponseListener listener) {
        if (this.mXMLListeners != null) {
            this.mXMLListeners.remove(listener);
        }
    }
}
