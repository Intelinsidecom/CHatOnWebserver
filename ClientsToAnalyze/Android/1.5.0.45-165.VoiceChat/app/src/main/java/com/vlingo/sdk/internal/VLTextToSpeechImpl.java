package com.vlingo.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vlingo.sdk.internal.audio.TTSRequest;
import com.vlingo.sdk.internal.audio.TTSRequestParams;
import com.vlingo.sdk.internal.audio.TTSServerManager;
import com.vlingo.sdk.internal.http.HttpCallback;
import com.vlingo.sdk.internal.http.HttpRequest;
import com.vlingo.sdk.internal.http.HttpResponse;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.settings.Settings;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.vlservice.VLHttpServiceRequest;
import com.vlingo.sdk.tts.VLTextToSpeech;
import com.vlingo.sdk.tts.VLTextToSpeechErrors;
import com.vlingo.sdk.tts.VLTextToSpeechListener;
import com.vlingo.sdk.tts.VLTextToSpeechRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public final class VLTextToSpeechImpl extends VLComponentImpl implements VLTextToSpeech, HttpCallback {

    /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$tts$VLTextToSpeechRequest$SpeechRate */
    private static /* synthetic */ int[] f3248xb74ffd33;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$tts$VLTextToSpeechRequest$Type;
    private static Logger log = Logger.getLogger(VLTextToSpeechImpl.class);
    private VLHttpServiceRequest mCurrentRequest;
    private String mFilename;
    private NotificationHandler mNotificationHandler;
    private VLTextToSpeechListener mTextToSpeechListener;

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$tts$VLTextToSpeechRequest$SpeechRate */
    static /* synthetic */ int[] m3091xb74ffd33() {
        int[] iArr = f3248xb74ffd33;
        if (iArr == null) {
            iArr = new int[VLTextToSpeechRequest.SpeechRate.valuesCustom().length];
            try {
                iArr[VLTextToSpeechRequest.SpeechRate.FAST.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VLTextToSpeechRequest.SpeechRate.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VLTextToSpeechRequest.SpeechRate.SLOW.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[VLTextToSpeechRequest.SpeechRate.VERY_FAST.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[VLTextToSpeechRequest.SpeechRate.VERY_SLOW.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            f3248xb74ffd33 = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$tts$VLTextToSpeechRequest$Type() {
        int[] iArr = $SWITCH_TABLE$com$vlingo$sdk$tts$VLTextToSpeechRequest$Type;
        if (iArr == null) {
            iArr = new int[VLTextToSpeechRequest.Type.valuesCustom().length];
            try {
                iArr[VLTextToSpeechRequest.Type.EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VLTextToSpeechRequest.Type.MMS.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VLTextToSpeechRequest.Type.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[VLTextToSpeechRequest.Type.SMS.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$vlingo$sdk$tts$VLTextToSpeechRequest$Type = iArr;
        }
        return iArr;
    }

    private class NotificationHandler extends Handler {
        static final int ERROR = 2;
        static final int SUCCESS = 1;

        NotificationHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            VLTextToSpeechImpl.this.setBusy(false);
            VLTextToSpeechListener l = VLTextToSpeechImpl.this.mTextToSpeechListener;
            VLTextToSpeechImpl.this.mTextToSpeechListener = null;
            switch (msg.what) {
                case 1:
                    if (l != null) {
                        l.onSuccess();
                        break;
                    }
                    break;
                case 2:
                    if (l != null) {
                        VLTextToSpeechErrors errorCode = (VLTextToSpeechErrors) ((Object[]) msg.obj)[0];
                        String errorMsg = (String) ((Object[]) msg.obj)[1];
                        l.onError(errorCode, errorMsg);
                        break;
                    }
                    break;
            }
        }

        synchronized void notifySuccess() {
            obtainMessage(1).sendToTarget();
        }

        synchronized void notifyError(VLTextToSpeechErrors error, String message) {
            obtainMessage(2, new Object[]{error, message}).sendToTarget();
        }

        synchronized void cancelNotifications() {
            removeMessages(1);
            removeMessages(2);
        }
    }

    public VLTextToSpeechImpl(VLComponentManager manager, Handler handler) {
        super(manager, handler);
        log.debug("VLTextToSpeechImpl()");
        this.mNotificationHandler = new NotificationHandler();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl
    void onDestroy() {
        log.debug("onDestroy()");
        this.mTextToSpeechListener = null;
    }

    @Override // com.vlingo.sdk.tts.VLTextToSpeech
    public void synthesizeToFile(VLTextToSpeechRequest request, String filename, VLTextToSpeechListener listener) {
        log.debug("synthesizeToFile(), filename=" + filename);
        validateInstance();
        if (request == null) {
            throw new IllegalArgumentException("request cannot be null");
        }
        if (StringUtils.isNullOrWhiteSpace(filename)) {
            throw new IllegalArgumentException("filename cannot be null or empty");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must be specifed");
        }
        if (isBusy()) {
            throw new IllegalStateException("TextToSpeech request already in progress");
        }
        setBusy(true);
        this.mTextToSpeechListener = listener;
        this.mFilename = filename;
        final TTSRequest ttsRequest = getTTSRequest(request);
        final String language = request.getLanguage();
        getHandler().post(new Runnable() { // from class: com.vlingo.sdk.internal.VLTextToSpeechImpl.1
            @Override // java.lang.Runnable
            public void run() {
                VLTextToSpeechImpl.this.mCurrentRequest = TTSServerManager.createTTSRequest(ttsRequest, language, VLTextToSpeechImpl.this);
                VLTextToSpeechImpl.this.mCurrentRequest.schedule(0L, true, true);
            }
        });
    }

    @Override // com.vlingo.sdk.tts.VLTextToSpeech
    public void cancel() {
        log.debug("cancel()");
        validateInstance();
        synchronized (this) {
            if (this.mCurrentRequest != null) {
                this.mCurrentRequest.cancel();
                this.mCurrentRequest = null;
            }
        }
        this.mTextToSpeechListener = null;
        this.mNotificationHandler.cancelNotifications();
        setBusy(false);
    }

    @Override // com.vlingo.sdk.tts.VLTextToSpeech
    public String[] getSupportedLanguageList() {
        log.debug("getSupportedLanguageList()");
        validateInstance();
        return Settings.SUPPORTED_LANGUAGES;
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public synchronized void onWillExecuteRequest(HttpRequest request) {
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public synchronized void onResponse(HttpRequest request, HttpResponse response) {
        byte[] audioData;
        log.debug("onResponse()");
        if (request == this.mCurrentRequest) {
            this.mCurrentRequest = null;
            if (response.responseCode == 200 && (audioData = TTSServerManager.parseTTSResponse(response)) != null) {
                try {
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(this.mFilename));
                    bos.write(audioData, 0, audioData.length);
                    bos.flush();
                    bos.close();
                    this.mNotificationHandler.notifySuccess();
                } catch (Exception e) {
                    log.debug("Unable to create file: " + this.mFilename);
                    this.mNotificationHandler.notifyError(VLTextToSpeechErrors.ERROR_CLIENT, Strings.tts_file_error);
                }
            } else {
                log.debug("Bad server response");
                this.mNotificationHandler.notifyError(VLTextToSpeechErrors.ERROR_SERVER, response.getDataAsString());
            }
        }
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public synchronized boolean onTimeout(HttpRequest request) {
        log.debug("onTimeout()");
        if (request == this.mCurrentRequest) {
            this.mCurrentRequest = null;
            this.mNotificationHandler.notifyError(VLTextToSpeechErrors.ERROR_NETWORK_TIMEOUT, Strings.client_core_NETWORK_TIMEOUT);
        }
        return true;
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public synchronized void onFailure(HttpRequest request) {
        log.debug("onFailure()");
        if (request == this.mCurrentRequest) {
            this.mCurrentRequest = null;
            this.mNotificationHandler.notifyError(VLTextToSpeechErrors.ERROR_NETWORK, Strings.client_core_network_error);
        }
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public synchronized void onCancelled(HttpRequest request) {
    }

    private static TTSRequest getTTSRequest(VLTextToSpeechRequest request) {
        TTSRequest ttsRequest;
        String speechRate;
        VLTextToSpeechRequest.Type type = request.getType();
        switch ($SWITCH_TABLE$com$vlingo$sdk$tts$VLTextToSpeechRequest$Type()[type.ordinal()]) {
            case 2:
                ttsRequest = TTSRequest.getEmail(request.getMsgFrom(), request.getMsgSubject(), request.getText(), request.getMsgReadyBody() ? false : true);
                break;
            case 3:
                ttsRequest = TTSRequest.getSMS(request.getMsgFrom(), request.getText(), request.getMsgReadyBody() ? false : true);
                break;
            case 4:
                ttsRequest = TTSRequest.getMMS(request.getMsgFrom(), request.getMsgSubject(), request.getMsgReadyBody() ? false : true);
                break;
            default:
                ttsRequest = TTSRequest.getText(request.getText());
                break;
        }
        VLTextToSpeechRequest.VoiceType voice = request.getVoice();
        VLTextToSpeechRequest.SpeechRate rate = request.getSpeechRate();
        String gender = voice == VLTextToSpeechRequest.VoiceType.MALE ? TTSRequestParams.GENDER_MALE : TTSRequestParams.GENDER_FEMALE;
        switch (m3091xb74ffd33()[rate.ordinal()]) {
            case 1:
                speechRate = TTSRequestParams.SPEECHRATE_VERYSLOW;
                break;
            case 2:
                speechRate = TTSRequestParams.SPEECHRATE_SLOW;
                break;
            case 3:
            default:
                speechRate = TTSRequestParams.SPEECHRATE_NORMAL;
                break;
            case 4:
                speechRate = TTSRequestParams.SPEECHRATE_FAST;
                break;
            case 5:
                speechRate = TTSRequestParams.SPEECHRATE_VERYFAST;
                break;
        }
        ttsRequest.setGender(gender);
        ttsRequest.setWordLimit(request.getMaxWords());
        ttsRequest.setSpeechRate(speechRate);
        return ttsRequest;
    }
}
