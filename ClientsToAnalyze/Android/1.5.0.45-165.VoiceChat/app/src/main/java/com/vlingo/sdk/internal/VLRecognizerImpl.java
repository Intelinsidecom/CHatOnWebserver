package com.vlingo.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vlingo.sdk.internal.audio.SpeexJNI;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.recognizer.Recognizer;
import com.vlingo.sdk.internal.recognizer.RecognizerListener;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.SRStatisticsCollection;
import com.vlingo.sdk.internal.recognizer.XMLResponseListener;
import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;
import com.vlingo.sdk.internal.settings.Settings;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.vlservice.response.ServerMessage;
import com.vlingo.sdk.recognition.VLRecognitionContext;
import com.vlingo.sdk.recognition.VLRecognitionErrors;
import com.vlingo.sdk.recognition.VLRecognitionListener;
import com.vlingo.sdk.recognition.VLRecognitionResult;
import com.vlingo.sdk.recognition.VLRecognitionStates;
import com.vlingo.sdk.recognition.VLRecognitionWarnings;
import com.vlingo.sdk.recognition.VLRecognitionWarningsCodes;
import com.vlingo.sdk.recognition.VLRecognizer;
import com.vlingo.sdk.recognition.dialog.VLDialogContext;

/* loaded from: classes.dex */
public final class VLRecognizerImpl extends VLComponentImpl implements VLRecognizer {
    private static Logger log = Logger.getLogger(VLRecognizerImpl.class);
    private RecognizerListener mCurrentRecognizerListener;
    private final NotificationHandler mNotificationHandler;
    private VLRecognitionContext mRecoContext;
    private VLRecognitionListener mRecoListener;
    private Recognizer mRecognizer;

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    private class NotificationHandler extends Handler {
        static final int ERROR = 5;
        static final int RESULT = 3;
        static final int RMS = 2;
        static final int STATE = 1;
        static final int WARNING = 4;

        NotificationHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (VLRecognizerImpl.this.mRecoListener != null) {
                        VLRecognizerImpl.this.mRecoListener.onStateChanged((VLRecognitionStates) msg.obj);
                        break;
                    }
                    break;
                case 2:
                    if (VLRecognizerImpl.this.mRecoListener != null) {
                        VLRecognizerImpl.this.mRecoListener.onRmsChanged(((Integer) msg.obj).intValue());
                        break;
                    }
                    break;
                case 3:
                    VLRecognizerImpl.this.setBusy(false);
                    if (VLRecognizerImpl.this.mRecoListener != null) {
                        VLRecognitionListener l = VLRecognizerImpl.this.mRecoListener;
                        VLRecognizerImpl.this.mRecoListener = null;
                        l.onRecognitionResults((VLRecognitionResult) msg.obj);
                        break;
                    }
                    break;
                case 4:
                    if (VLRecognizerImpl.this.mRecoListener != null) {
                        VLRecognitionWarnings warningCode = (VLRecognitionWarnings) ((Object[]) msg.obj)[0];
                        String warningMsg = (String) ((Object[]) msg.obj)[1];
                        VLRecognizerImpl.this.mRecoListener.onWarning(warningCode, warningMsg);
                        break;
                    }
                    break;
                case 5:
                    VLRecognitionErrors errorCode = (VLRecognitionErrors) ((Object[]) msg.obj)[0];
                    String errorMsg = (String) ((Object[]) msg.obj)[1];
                    VLRecognizerImpl.this.setBusy(false);
                    if (VLRecognizerImpl.this.mRecoListener != null) {
                        VLRecognitionListener l2 = VLRecognizerImpl.this.mRecoListener;
                        VLRecognizerImpl.this.mRecoListener = null;
                        l2.onError(errorCode, errorMsg);
                        break;
                    }
                    break;
            }
        }

        synchronized void notifyRmsChange(Object rmsValue) {
            obtainMessage(2, rmsValue).sendToTarget();
        }

        synchronized void notifyEvent(VLRecognitionStates newState) {
            obtainMessage(1, newState).sendToTarget();
        }

        synchronized void notifyResult(VLRecognitionResult result) {
            obtainMessage(3, result).sendToTarget();
        }

        synchronized void notifyWarning(VLRecognitionWarnings warning, String message) {
            obtainMessage(4, new Object[]{warning, message}).sendToTarget();
        }

        synchronized void notifyError(VLRecognitionErrors error, String message) {
            obtainMessage(5, new Object[]{error, message}).sendToTarget();
        }

        synchronized void clear() {
            removeMessages(2);
            removeMessages(1);
            removeMessages(3);
            removeMessages(4);
            removeMessages(5);
        }
    }

    public VLRecognizerImpl(VLComponentManager manager, Handler handler) {
        super(manager, handler);
        log.debug("VLRecognizerImpl()");
        this.mNotificationHandler = new NotificationHandler();
        SpeexJNI.init();
        this.mRecognizer = new Recognizer();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl
    void onDestroy() {
        log.debug("onDestroy()");
        this.mCurrentRecognizerListener = null;
        this.mRecognizer.destroy();
        this.mRecognizer = null;
        this.mRecoListener = null;
    }

    @Override // com.vlingo.sdk.recognition.VLRecognizer
    public void startRecognition(VLRecognitionContext context, VLRecognitionListener listener) {
        log.debug("startRecognition()");
        validateInstance();
        if (context == null) {
            throw new IllegalArgumentException("context must be specified");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must be specified");
        }
        if (context.getAudioSourceInfo() == null) {
            throw new IllegalArgumentException("AudioSourceInfo is required for startRecognition()");
        }
        if (isBusy()) {
            throw new IllegalStateException("Recognition already in progress");
        }
        setBusy(true);
        this.mRecoListener = listener;
        this.mRecoContext = context;
        Settings.LANGUAGE = this.mRecoContext.getLanguage();
        this.mCurrentRecognizerListener = new RecognitionListenerImpl(this, null);
        getHandler().post(new Runnable() { // from class: com.vlingo.sdk.internal.VLRecognizerImpl.1
            RecognizerListener mListener;

            {
                this.mListener = VLRecognizerImpl.this.mCurrentRecognizerListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (VLRecognizerImpl.this.getDestroyLock()) {
                    if (VLRecognizerImpl.this.isValid()) {
                        VLRecognizerImpl.this.mNotificationHandler.notifyEvent(VLRecognitionStates.GETTING_READY);
                        try {
                            VLRecognizerImpl.this.mRecognizer.startRecognition(VLRecognizerImpl.this.getSRContext(), this.mListener);
                        } catch (IllegalStateException e) {
                            VLRecognizerImpl.log.debug("Failed to start recognizer");
                            VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_RECOGNIZER_BUSY, "Failed to start recognition.");
                        }
                    }
                }
            }
        });
    }

    @Override // com.vlingo.sdk.recognition.VLRecognizer
    public void sendEvent(VLDialogContext context, VLRecognitionListener listener) {
        log.debug("sendEvent()");
        validateInstance();
        if (context == null) {
            throw new IllegalArgumentException("context must be specified");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must be specifed");
        }
        if (context.getEvents() == null || context.getEvents().size() == 0) {
            throw new IllegalArgumentException("context must contain at least 1 event");
        }
        if (isBusy()) {
            throw new IllegalStateException("Recognition already in progress");
        }
        setBusy(true);
        this.mRecoListener = listener;
        this.mRecoContext = context;
        Settings.LANGUAGE = this.mRecoContext.getLanguage();
        this.mCurrentRecognizerListener = new RecognitionListenerImpl(this, null);
        getHandler().post(new Runnable() { // from class: com.vlingo.sdk.internal.VLRecognizerImpl.2
            RecognizerListener mListener;

            {
                this.mListener = VLRecognizerImpl.this.mCurrentRecognizerListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (VLRecognizerImpl.this.getDestroyLock()) {
                    if (VLRecognizerImpl.this.isValid()) {
                        VLRecognizerImpl.this.mNotificationHandler.notifyEvent(VLRecognitionStates.GETTING_READY);
                        try {
                            VLRecognizerImpl.this.mRecognizer.startSendEvent(VLRecognizerImpl.this.getSRContext(), this.mListener);
                        } catch (IllegalStateException e) {
                            VLRecognizerImpl.log.debug("Failed to start recognizer");
                            VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_RECOGNIZER_BUSY, "Failed to start recognition.");
                        }
                    }
                }
            }
        });
    }

    @Override // com.vlingo.sdk.recognition.VLRecognizer
    public void stopRecognition() {
        log.debug("stopRecognition()");
        validateInstance();
        getHandler().post(new Runnable() { // from class: com.vlingo.sdk.internal.VLRecognizerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (VLRecognizerImpl.this.getDestroyLock()) {
                    if (VLRecognizerImpl.this.isValid()) {
                        VLRecognizerImpl.this.mRecognizer.stop();
                    }
                }
            }
        });
    }

    @Override // com.vlingo.sdk.recognition.VLRecognizer
    public void cancelRecognition() {
        log.debug("cancelRecognition()");
        validateInstance();
        final VLRecognitionListener l = this.mRecoListener;
        this.mRecoListener = null;
        this.mCurrentRecognizerListener = null;
        this.mNotificationHandler.clear();
        getHandler().post(new Runnable() { // from class: com.vlingo.sdk.internal.VLRecognizerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (VLRecognizerImpl.this) {
                    if (VLRecognizerImpl.this.isValid()) {
                        VLRecognizerImpl.this.mRecognizer.cancel();
                    }
                }
            }
        });
        if (l != null) {
            this.mNotificationHandler.post(new Runnable() { // from class: com.vlingo.sdk.internal.VLRecognizerImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    VLRecognizerImpl.this.setBusy(false);
                    l.onCancelled();
                }
            });
        }
    }

    @Override // com.vlingo.sdk.recognition.VLRecognizer
    public void acceptedText(final String GUttId, String text) {
        log.debug("acceptedText(), GUttId=" + GUttId + ", text=" + text);
        validateInstance();
        if (!StringUtils.isNullOrWhiteSpace(text)) {
            final SRStatisticsCollection collection = new SRStatisticsCollection();
            collection.setAcceptedText(text);
            getHandler().post(new Runnable() { // from class: com.vlingo.sdk.internal.VLRecognizerImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (VLRecognizerImpl.this) {
                        if (VLRecognizerImpl.this.isValid()) {
                            VLRecognizerImpl.this.mRecognizer.sendAcceptedText(GUttId, collection);
                        }
                    }
                }
            });
        }
    }

    @Override // com.vlingo.sdk.recognition.VLRecognizer
    public String[] getSupportedLanguageList() {
        validateInstance();
        return Settings.SUPPORTED_LANGUAGES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SRContext getSRContext() {
        SRContext srContext = new SRContext();
        srContext.setFieldID(this.mRecoContext.getFieldID());
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isNullOrWhiteSpace(this.mRecoContext.getAppName())) {
            sb.append(this.mRecoContext.getAppName());
        }
        if (!StringUtils.isNullOrWhiteSpace(this.mRecoContext.getScreenName())) {
            sb.append(String.valueOf(':') + this.mRecoContext.getScreenName());
            if (!StringUtils.isNullOrWhiteSpace(this.mRecoContext.getControlName())) {
                sb.append(String.valueOf(':') + this.mRecoContext.getControlName());
            }
        } else if (!StringUtils.isNullOrWhiteSpace(this.mRecoContext.getControlName())) {
            sb.append("::" + this.mRecoContext.getControlName());
        }
        srContext.setFieldContext(sb.toString());
        srContext.setCurText(this.mRecoContext.getCurrentText());
        srContext.setCursorPos(this.mRecoContext.getCursorPosition());
        srContext.setAutoPunctuation(this.mRecoContext.getAutoPunctuation());
        srContext.setProfanityFilter(this.mRecoContext.getProfanityFilter());
        srContext.setCapitalizationMode(this.mRecoContext.getCapitalizationMode());
        srContext.setMaxAudioTime(this.mRecoContext.getMaxAudioTime());
        srContext.setAutoEndpointing(this.mRecoContext.autoEndpointingEnabled());
        srContext.setSilenceDetectionParams(this.mRecoContext.getSilenceThreshold(), this.mRecoContext.getMinVoiceDuration(), this.mRecoContext.getVoicePortion(), this.mRecoContext.getMinVoiceLevel());
        srContext.setSpeexParams(this.mRecoContext.getSpeexComplexity(), this.mRecoContext.getSpeexQuality(), this.mRecoContext.getSpeexVariableBitrate(), this.mRecoContext.getSpeexVoiceActivityDetection());
        srContext.setSpeechEndpointTimeout(this.mRecoContext.getSpeechEndpointTimeout());
        srContext.setNoSpeechEndpointTimeout(this.mRecoContext.getNoSpeechEndPointTimeout());
        srContext.setAudioSourceInfo(this.mRecoContext.getAudioSourceInfo());
        if (this.mRecoContext instanceof VLDialogContext) {
            srContext.setIsDMRequest(true);
            srContext.setDialogState(((VLDialogContext) this.mRecoContext).getDialogState());
            srContext.setEvents(((VLDialogContext) this.mRecoContext).getEvents());
            srContext.setUsername(((VLDialogContext) this.mRecoContext).getUsername());
            srContext.setDialogGUID(((VLDialogContext) this.mRecoContext).getDialogGUID());
            srContext.setDialogTurnNumber(((VLDialogContext) this.mRecoContext).getDialogTurnNumber());
            srContext.setDMHeaderKVPairs(((VLDialogContext) this.mRecoContext).getDMHeaderKVPairs());
        }
        return srContext;
    }

    private class RecognitionListenerImpl implements RecognizerListener {

        /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$internal$recognizer$RecognizerListener$RecognizerError */
        private static /* synthetic */ int[] f3246x3649e1c;

        /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$internal$recognizer$RecognizerListener$RecognizerState */
        private static /* synthetic */ int[] f3247x42a90a5;

        /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$internal$recognizer$RecognizerListener$RecognizerError */
        static /* synthetic */ int[] m3089x3649e1c() {
            int[] iArr = f3246x3649e1c;
            if (iArr == null) {
                iArr = new int[RecognizerListener.RecognizerError.valuesCustom().length];
                try {
                    iArr[RecognizerListener.RecognizerError.FAIL_CONNECT.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[RecognizerListener.RecognizerError.NO_RESULTS.ordinal()] = 5;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[RecognizerListener.RecognizerError.NO_SPEECH.ordinal()] = 6;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[RecognizerListener.RecognizerError.READER_ERROR.ordinal()] = 3;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[RecognizerListener.RecognizerError.TIMEOUT.ordinal()] = 2;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[RecognizerListener.RecognizerError.TOO_SHORT.ordinal()] = 4;
                } catch (NoSuchFieldError e6) {
                }
                f3246x3649e1c = iArr;
            }
            return iArr;
        }

        /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$internal$recognizer$RecognizerListener$RecognizerState */
        static /* synthetic */ int[] m3090x42a90a5() {
            int[] iArr = f3247x42a90a5;
            if (iArr == null) {
                iArr = new int[RecognizerListener.RecognizerState.valuesCustom().length];
                try {
                    iArr[RecognizerListener.RecognizerState.CONNECTING.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[RecognizerListener.RecognizerState.LISTENING.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[RecognizerListener.RecognizerState.RECEIVING.ordinal()] = 6;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[RecognizerListener.RecognizerState.RESULT.ordinal()] = 7;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[RecognizerListener.RecognizerState.RMS_CHANGED.ordinal()] = 3;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[RecognizerListener.RecognizerState.SENDING.ordinal()] = 4;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[RecognizerListener.RecognizerState.THINKING.ordinal()] = 5;
                } catch (NoSuchFieldError e7) {
                }
                f3247x42a90a5 = iArr;
            }
            return iArr;
        }

        private RecognitionListenerImpl() {
        }

        /* synthetic */ RecognitionListenerImpl(VLRecognizerImpl vLRecognizerImpl, RecognitionListenerImpl recognitionListenerImpl) {
            this();
        }

        @Override // com.vlingo.sdk.internal.recognizer.RecognizerListener
        public void onRecognizerStateChanged(RecognizerListener.RecognizerState recState, Object data) {
            if (this == VLRecognizerImpl.this.mCurrentRecognizerListener) {
                VLRecognizerImpl.log.debug("onRecognitionStateChanged recState=" + recState.name() + ", data=" + data);
                switch (m3090x42a90a5()[recState.ordinal()]) {
                    case 1:
                        VLRecognizerImpl.this.mNotificationHandler.notifyEvent(VLRecognitionStates.CONNECTING);
                        break;
                    case 2:
                        VLRecognizerImpl.this.mNotificationHandler.notifyEvent(VLRecognitionStates.LISTENING);
                        break;
                    case 3:
                        VLRecognizerImpl.this.mNotificationHandler.notifyRmsChange(data);
                        break;
                    case 5:
                        VLRecognizerImpl.this.mNotificationHandler.notifyEvent(VLRecognitionStates.THINKING);
                        break;
                }
            }
        }

        @Override // com.vlingo.sdk.internal.recognizer.RecognizerListener
        public void onRecognizerError(RecognizerListener.RecognizerError recError, String message) {
            if (this == VLRecognizerImpl.this.mCurrentRecognizerListener) {
                VLRecognizerImpl.log.debug("onRecognizerError recError=" + recError.name() + ", message=" + message);
                switch (m3089x3649e1c()[recError.ordinal()]) {
                    case 1:
                        VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_NETWORK, message);
                        break;
                    case 2:
                        VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_NETWORK_TIMEOUT, message);
                        break;
                    case 3:
                        VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_AUDIO, message);
                        break;
                    case 4:
                        VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_NO_MATCH, message);
                        break;
                    case 5:
                        VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_SERVER, message);
                        break;
                    case 6:
                        VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_SPEECH_TIMEOUT, message);
                        break;
                }
            }
        }

        @Override // com.vlingo.sdk.internal.recognizer.RecognizerListener
        public void onRecognitionResponse(SRRecognitionResponse response) {
            if (this == VLRecognizerImpl.this.mCurrentRecognizerListener) {
                VLRecognizerImpl.log.debug("onRecognitionResponse()");
                if (response.isError()) {
                    VLRecognizerImpl.this.mNotificationHandler.notifyError(VLRecognitionErrors.ERROR_SERVER, response.getFirstMessage().getMessage());
                    return;
                }
                VLRecognitionResult vlResult = new VLRecognitionResultImpl(response);
                if (response.hasWarnings()) {
                    ServerMessage msg = response.getFirstMessage();
                    String code = msg.getCode();
                    if (!code.equals(VLRecognitionWarningsCodes.NOTHING_RECOGNIZED) || !StringUtils.isNullOrWhiteSpace(vlResult.getResultString())) {
                        VLRecognizerImpl.this.mNotificationHandler.notifyWarning(VLRecognitionWarnings.WARNING_SERVER, msg.getMessage());
                    } else {
                        VLRecognizerImpl.this.mNotificationHandler.notifyWarning(VLRecognitionWarnings.WARNING_NOTHING_RECOGNIZED, msg.getMessage());
                    }
                }
                VLRecognizerImpl.this.mNotificationHandler.notifyResult(vlResult);
            }
        }
    }

    @Override // com.vlingo.sdk.recognition.VLRecognizer
    public void addXMLResponseListener(XMLResponseListener listener) {
        if (this.mRecognizer != null) {
            this.mRecognizer.addXMLResponseListener(listener);
        }
    }

    @Override // com.vlingo.sdk.recognition.VLRecognizer
    public void removeXMLResponseListener(XMLResponseListener listener) {
        if (this.mRecognizer != null) {
            this.mRecognizer.removeXMLResponseListener(listener);
        }
    }
}
