package com.vlingo.sdk.internal.recognizer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.coolots.p2pmsg.model.PhoneNoAuthRep;
import com.vlingo.sdk.internal.AndroidServerDetails;
import com.vlingo.sdk.internal.Strings;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.http.HttpManager;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.internal.recognizer.RecognizerListener;
import com.vlingo.sdk.internal.recognizer.reader.DataReader;
import com.vlingo.sdk.internal.recognizer.reader.DataReaderListener;
import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;
import com.vlingo.sdk.internal.util.StringUtils;

/* loaded from: classes.dex */
public class Recognizer {
    private static final int MIN_AUDIO_DURATION = 500;
    private int mBeginStopDelta;
    private DataReader mDataReader;
    private DataReaderListener mDataReaderListener;
    private int mEndStopDelta;
    private int mGotResultDelta;
    private RecognizerListener mListener;
    private int mParseResultDelta;
    private SRRequest mRequest;
    private SRRequestListener mRequestListener;
    private int mSendFinishDelta;
    private int mSendStartDelta;
    private int mStartDelta;
    private long mStartTime;
    private int mUttBytes;
    private Logger log = Logger.getLogger(Recognizer.class);
    private String lastGuttID = null;
    private TimingRepository mTimings = new TimingRepository();
    private SRManager mSRManager = SRManager.create(ConnectionManager.getInstance(), this.mTimings);

    public Recognizer() {
        this.mSRManager.init(new AndroidServerDetails(), ClientMeta.getInstance(), SoftwareMeta.getInstance());
    }

    public synchronized void startRecognition(SRContext srContext, RecognizerListener listener) {
        this.log.debug("startRecognition()");
        if (srContext.getAudioSourceInfo().isString()) {
            if (prepareStart(srContext, false, listener)) {
                this.mStartDelta = (int) (System.currentTimeMillis() - this.mStartTime);
                handleStateChange(RecognizerListener.RecognizerState.THINKING, null);
            }
        } else if (prepareStart(srContext, true, listener)) {
            this.mDataReaderListener = new DataReaderListenerImpl(this, null);
            this.mDataReader = DataReader.getDataReader(srContext, this.mDataReaderListener);
            this.mDataReader.SetTimings(this.mTimings);
            if (!this.mDataReader.init()) {
                handleError(RecognizerListener.RecognizerError.READER_ERROR, Strings.client_core_readerinit_error);
            } else {
                this.mDataReader.start();
            }
        }
    }

    public synchronized void startSendEvent(SRContext srContext, RecognizerListener listener) {
        this.log.debug("startSendEvent()");
        if (prepareStart(srContext, false, listener)) {
            this.mStartDelta = (int) (System.currentTimeMillis() - this.mStartTime);
            handleStateChange(RecognizerListener.RecognizerState.THINKING, null);
        }
    }

    public synchronized void stop() {
        this.log.debug("stop()");
        this.mBeginStopDelta = (int) (System.currentTimeMillis() - this.mStartTime);
        if (this.mDataReader != null) {
            this.mDataReader.stop();
        }
    }

    public synchronized void cancel() {
        this.log.debug("cancel()");
        cleanup();
    }

    public synchronized void sendAcceptedText(String GUttId, SRStatisticsCollection collection) {
        this.log.debug("sendAcceptedText() GUttId=" + GUttId + ", collection=" + collection.getAcceptedText());
        if (collection.getAcceptedText() != null && GUttId != null && (this.lastGuttID == null || !GUttId.equals(this.lastGuttID))) {
            SRStatistics stats = new SRStatistics(GUttId, SRStatistics.TYPE_ACCEPTED_TEXT);
            stats.addStatistic(SRStatistics.STAT_ACCEPTED_TEXT, collection.getAcceptedText());
            collection.addStatistics(stats);
            this.lastGuttID = GUttId;
        }
        this.mSRManager.sendStatsCollection(collection);
    }

    public synchronized void destroy() {
        this.log.debug("destroy()");
        cleanup();
        this.mSRManager.destroy();
    }

    private boolean prepareStart(SRContext srContext, boolean sendAudio, RecognizerListener listener) {
        this.log.debug("prepareStart()");
        if (listener == null) {
            throw new IllegalArgumentException("listener is null");
        }
        if (this.mListener != null) {
            throw new IllegalStateException(Strings.client_core_recognizer_busy);
        }
        this.mListener = listener;
        this.mTimings.clear();
        this.mTimings.markTimeZero();
        this.mStartTime = System.currentTimeMillis();
        this.mStartDelta = -1;
        this.mBeginStopDelta = -1;
        this.mEndStopDelta = -1;
        this.mSendStartDelta = -1;
        this.mSendFinishDelta = -1;
        this.mGotResultDelta = -1;
        this.mParseResultDelta = -1;
        this.mUttBytes = 0;
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null || netInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) {
            handleError(RecognizerListener.RecognizerError.FAIL_CONNECT, Strings.client_core_NETWORK_NOT_AVAILABLE);
            return false;
        }
        this.mRequestListener = new SRRequestListenerImpl(this, null);
        this.mRequest = this.mSRManager.newRequest(srContext, this.mRequestListener, sendAudio);
        this.mTimings.recordAndTimeStampEvent("RSC");
        return true;
    }

    private void sendRecTiming(String guttId) {
        this.log.debug("sendRectiming() guttId=" + guttId);
        SRStatistics stats = new SRStatistics(guttId, SRStatistics.TYPE_REC_TIMING);
        stats.addStatistic("BOR", new StringBuilder().append(this.mStartDelta).toString());
        stats.addStatistic("EOS", new StringBuilder().append(this.mBeginStopDelta).toString());
        stats.addStatistic("EOR", new StringBuilder().append(this.mEndStopDelta).toString());
        stats.addStatistic("Custom1", new StringBuilder().append(this.mSendStartDelta).toString());
        stats.addStatistic("EOD", new StringBuilder().append(this.mSendFinishDelta).toString());
        stats.addStatistic("SED", PhoneNoAuthRep.AUTH_RESULT_FAIL);
        stats.addStatistic("RES", new StringBuilder().append(this.mGotResultDelta).toString());
        stats.addStatistic("PAR", new StringBuilder().append(this.mParseResultDelta).toString());
        stats.addStatistic("UTT", new StringBuilder().append(this.mUttBytes).toString());
        stats.addStatistic("Custom2", this.mTimings.getStatString());
        this.log.info("Sending stats srmanager " + this.mSRManager);
        this.mSRManager.sendStatistics(stats);
        this.log.info("done with sendRecTiming");
    }

    private void cleanup() {
        this.log.debug("cleanup()");
        HttpManager.getInstance().resume();
        if (this.mRequest != null) {
            this.mRequest.removeListener(this.mRequestListener);
            this.mRequest.cancel(false);
            this.mRequest = null;
        }
        if (this.mDataReader != null) {
            this.mDataReader.stop();
            this.mDataReader.writeLog();
            this.mDataReader = null;
        }
        this.mRequestListener = null;
        this.mDataReaderListener = null;
        this.mListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStateChange(RecognizerListener.RecognizerState state, Object data) {
        if (state == RecognizerListener.RecognizerState.LISTENING) {
            HttpManager.getInstance().pause();
        }
        this.mListener.onRecognizerStateChanged(state, data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleError(RecognizerListener.RecognizerError recError, String msg) {
        this.mListener.onRecognizerError(recError, msg);
        cleanup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResponse(SRRecognitionResponse response) {
        String guttId = response.getGUttId();
        if (this.mDataReader != null) {
            this.mDataReader.setGuttId(guttId);
        }
        if (!response.hasActions() && !response.hasResults() && !response.hasMessages() && !response.hasDialogState()) {
            this.mListener.onRecognizerError(RecognizerListener.RecognizerError.NO_RESULTS, Strings.client_core_server_error);
        } else {
            this.mListener.onRecognitionResponse(response);
        }
        cleanup();
        if (!StringUtils.isNullOrWhiteSpace(guttId)) {
            sendRecTiming(guttId);
        }
    }

    private class SRRequestListenerImpl implements SRRequestListener {
        private SRRequestListenerImpl() {
        }

        /* synthetic */ SRRequestListenerImpl(Recognizer recognizer, SRRequestListenerImpl sRRequestListenerImpl) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.SRRequestListener
        public void resultReceived(SRRecognitionResponse response) {
            synchronized (Recognizer.this) {
                if (this == Recognizer.this.mRequestListener) {
                    Recognizer.this.log.debug("resultReceived()");
                    Recognizer.this.mSendStartDelta = (int) (Recognizer.this.mRequest.getTimeSendStart() - Recognizer.this.mStartTime);
                    Recognizer.this.mSendFinishDelta = (int) (Recognizer.this.mRequest.getTimeSendFinish() - Recognizer.this.mStartTime);
                    Recognizer.this.mGotResultDelta = (int) (Recognizer.this.mRequest.getTimeGotResult() - Recognizer.this.mStartTime);
                    Recognizer.this.mParseResultDelta = (int) (System.currentTimeMillis() - Recognizer.this.mStartTime);
                    Recognizer.this.handleResponse(response);
                }
            }
        }

        @Override // com.vlingo.sdk.internal.recognizer.SRRequestListener
        public void requestFailed(int state) {
            synchronized (Recognizer.this) {
                if (this == Recognizer.this.mRequestListener) {
                    Recognizer.this.log.debug("requestFailed() state=" + state);
                    Recognizer.this.handleError(RecognizerListener.RecognizerError.FAIL_CONNECT, Strings.client_core_network_error);
                }
            }
        }

        @Override // com.vlingo.sdk.internal.recognizer.SRRequestListener
        public void stateChanged(int state) {
            synchronized (Recognizer.this) {
                if (this == Recognizer.this.mRequestListener) {
                    Recognizer.this.log.debug("stateChanged() state=" + state);
                    switch (state) {
                        case 1:
                            Recognizer.this.handleStateChange(RecognizerListener.RecognizerState.CONNECTING, null);
                            break;
                        case 2:
                            Recognizer.this.handleStateChange(RecognizerListener.RecognizerState.SENDING, null);
                            break;
                        case 3:
                            Recognizer.this.handleStateChange(RecognizerListener.RecognizerState.RECEIVING, null);
                            break;
                    }
                }
            }
        }
    }

    private class DataReaderListenerImpl implements DataReaderListener {
        private DataReaderListenerImpl() {
        }

        /* synthetic */ DataReaderListenerImpl(Recognizer recognizer, DataReaderListenerImpl dataReaderListenerImpl) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.reader.DataReaderListener
        public void onStarted() {
            synchronized (Recognizer.this) {
                if (this == Recognizer.this.mDataReaderListener) {
                    Recognizer.this.log.debug("onStarted()");
                    Recognizer.this.mStartDelta = (int) (System.currentTimeMillis() - Recognizer.this.mStartTime);
                    Recognizer.this.handleStateChange(RecognizerListener.RecognizerState.LISTENING, null);
                }
            }
        }

        @Override // com.vlingo.sdk.internal.recognizer.reader.DataReaderListener
        public void onStopped(int totalDuration, boolean isSpeechDetected) {
            synchronized (Recognizer.this) {
                if (this == Recognizer.this.mDataReaderListener) {
                    Recognizer.this.log.debug("onStopped() totalDuration=" + totalDuration);
                    Recognizer.this.mEndStopDelta = (int) (System.currentTimeMillis() - Recognizer.this.mStartTime);
                    if (Recognizer.this.mBeginStopDelta == -1) {
                        Recognizer.this.mBeginStopDelta = Recognizer.this.mEndStopDelta;
                    }
                    if (!isSpeechDetected) {
                        Recognizer.this.log.debug("onStopped() EPD handleError NO_SPEECH, !isSpeechDetected totalDuration=" + totalDuration);
                        Recognizer.this.handleError(RecognizerListener.RecognizerError.NO_SPEECH, Strings.client_core_NO_SPEECH);
                    } else if (totalDuration <= -1 || totalDuration >= 500) {
                        Recognizer.this.handleStateChange(RecognizerListener.RecognizerState.THINKING, null);
                        Recognizer.this.mRequest.finish();
                    } else {
                        Recognizer.this.handleError(RecognizerListener.RecognizerError.TOO_SHORT, Strings.client_core_TOO_SHORT);
                    }
                }
            }
        }

        @Override // com.vlingo.sdk.internal.recognizer.reader.DataReaderListener
        public void onDataAvailable(byte[] buffer, int energy) {
            synchronized (Recognizer.this) {
                if (this == Recognizer.this.mDataReaderListener) {
                    Recognizer.this.log.debug("onDataAvailable() length=" + buffer.length + ", energy=" + energy);
                    if (energy > -1) {
                        Recognizer.this.handleStateChange(RecognizerListener.RecognizerState.RMS_CHANGED, Integer.valueOf(energy));
                    }
                    Recognizer.this.mRequest.sendAudio(buffer, 0, buffer.length);
                    Recognizer.this.mUttBytes += buffer.length;
                }
            }
        }

        @Override // com.vlingo.sdk.internal.recognizer.reader.DataReaderListener
        public void onError(DataReaderListener.ErrorCode code, String msg) {
            synchronized (Recognizer.this) {
                if (this == Recognizer.this.mDataReaderListener) {
                    Recognizer.this.log.debug("onError() code=" + code.name());
                    Recognizer.this.handleError(RecognizerListener.RecognizerError.READER_ERROR, msg);
                }
            }
        }
    }

    public void addXMLResponseListener(XMLResponseListener listener) {
        if (this.mSRManager != null) {
            this.mSRManager.addXMLResponseListener(listener);
        }
    }

    public void removeXMLResponseListener(XMLResponseListener listener) {
        if (this.mSRManager != null) {
            this.mSRManager.removeXMLResponseListener(listener);
        }
    }
}
