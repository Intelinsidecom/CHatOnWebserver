package com.vlingo.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vlingo.sdk.internal.http.HttpCallback;
import com.vlingo.sdk.internal.http.HttpRequest;
import com.vlingo.sdk.internal.http.HttpResponse;
import com.vlingo.sdk.internal.lmtt.LMTTComm;
import com.vlingo.sdk.internal.lmtt.LMTTItem;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.vlservice.VLHttpServiceRequest;
import com.vlingo.sdk.training.VLTrainer;
import com.vlingo.sdk.training.VLTrainerErrors;
import com.vlingo.sdk.training.VLTrainerListener;
import com.vlingo.sdk.training.VLTrainerUpdateList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class VLTrainerImpl extends VLComponentImpl implements VLTrainer, HttpCallback {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType;
    private static Logger log = Logger.getLogger(VLTrainerImpl.class);
    private NotificationHandler mNotificationHandler;
    private VLTrainerListener mTrainerListener;

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType() {
        int[] iArr = $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType;
        if (iArr == null) {
            iArr = new int[LMTTItem.LmttItemType.valuesCustom().length];
            try {
                iArr[LMTTItem.LmttItemType.TYPE_CONTACT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LMTTItem.LmttItemType.TYPE_PLAYLIST.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LMTTItem.LmttItemType.TYPE_SONG.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LMTTItem.LmttItemType.TYPE_UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType = iArr;
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
            VLTrainerImpl.this.setBusy(false);
            VLTrainerListener l = VLTrainerImpl.this.mTrainerListener;
            VLTrainerImpl.this.mTrainerListener = null;
            switch (msg.what) {
                case 1:
                    if (l != null) {
                        l.onUpdateReceived((HashMap) msg.obj);
                        break;
                    }
                    break;
                case 2:
                    if (l != null) {
                        VLTrainerErrors errorCode = (VLTrainerErrors) ((Object[]) msg.obj)[0];
                        String errorMsg = (String) ((Object[]) msg.obj)[1];
                        l.onError(errorCode, errorMsg);
                        break;
                    }
                    break;
            }
        }

        synchronized void notifySuccess(HashMap<VLTrainer.TrainerItemType, Integer> itemCount) {
            VLTrainerImpl.this.mNotificationHandler.obtainMessage(1, itemCount).sendToTarget();
        }

        synchronized void notifyError(VLTrainerErrors error, String message) {
            VLTrainerImpl.this.mNotificationHandler.obtainMessage(2, new Object[]{error, message}).sendToTarget();
        }
    }

    public VLTrainerImpl(VLComponentManager manager, Handler handler) {
        super(manager, handler);
        log.debug("VLTrainerImpl()");
        this.mNotificationHandler = new NotificationHandler();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl
    void onDestroy() {
        log.debug("onDestroy()");
        this.mTrainerListener = null;
    }

    @Override // com.vlingo.sdk.training.VLTrainer
    public void sendPartialUpdate(VLTrainerUpdateList list, String language, VLTrainerListener listener) {
        log.debug("sendPartialUpdate()");
        sendUpdate(list, language, listener, false);
    }

    @Override // com.vlingo.sdk.training.VLTrainer
    public void sendFullUpdate(VLTrainerUpdateList list, String language, VLTrainerListener listener) {
        log.debug("sendFullUpdate()");
        sendUpdate(list, language, listener, true);
    }

    @Override // com.vlingo.sdk.training.VLTrainer
    public void clearContactItems(String language, VLTrainerListener listener) {
        log.debug("clearContactItems()");
        VLTrainerUpdateListImpl list = new VLTrainerUpdateListImpl();
        list.addNOOPItem(VLTrainer.TrainerItemType.CONTACT);
        sendUpdate(list, language, listener, true);
    }

    @Override // com.vlingo.sdk.training.VLTrainer
    public void clearMusicItems(String language, VLTrainerListener listener) {
        log.debug("clearMusicItems()");
        VLTrainerUpdateListImpl list = new VLTrainerUpdateListImpl();
        list.addNOOPItem(VLTrainer.TrainerItemType.SONG);
        sendUpdate(list, language, listener, true);
    }

    @Override // com.vlingo.sdk.training.VLTrainer
    public void clearAllItems(String language, VLTrainerListener listener) {
        log.debug("clearAllItems()");
        VLTrainerUpdateListImpl list = new VLTrainerUpdateListImpl();
        list.addNOOPItem(VLTrainer.TrainerItemType.CONTACT);
        list.addNOOPItem(VLTrainer.TrainerItemType.SONG);
        sendUpdate(list, language, listener, true);
    }

    @Override // com.vlingo.sdk.training.VLTrainer
    public void updateTrainerModelLanguage(String language, VLTrainerListener listener) {
        log.debug("updateTrainerModelLanguage()");
        VLTrainerUpdateListImpl list = new VLTrainerUpdateListImpl();
        list.addNOOPItem(VLTrainer.TrainerItemType.CONTACT);
        list.addNOOPItem(VLTrainer.TrainerItemType.SONG);
        sendUpdate(list, language, listener, false);
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onWillExecuteRequest(HttpRequest request) {
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onResponse(HttpRequest request, HttpResponse response) {
        HashMap<LMTTItem.LmttItemType, Integer> counts;
        if (response.responseCode == 200 && (counts = LMTTComm.parseLMTTResponse(response)) != null) {
            this.mNotificationHandler.notifySuccess(lmttType2TrainerType(counts));
        } else {
            log.debug("Bad server response");
            this.mNotificationHandler.notifyError(VLTrainerErrors.ERROR_SERVER, response.getDataAsString());
        }
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public boolean onTimeout(HttpRequest request) {
        this.mNotificationHandler.notifyError(VLTrainerErrors.ERROR_NETWORK_TIMEOUT, Strings.client_core_NETWORK_TIMEOUT);
        return true;
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onFailure(HttpRequest request) {
        this.mNotificationHandler.notifyError(VLTrainerErrors.ERROR_NETWORK, Strings.client_core_network_error);
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onCancelled(HttpRequest request) {
    }

    private void sendUpdate(final VLTrainerUpdateList list, final String language, VLTrainerListener listener, final boolean doWhole) {
        log.debug("sendUpdate()");
        validateInstance();
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        if (!(list instanceof VLTrainerUpdateListImpl)) {
            throw new IllegalArgumentException("VLTrainerUpdateList instance must be obtained through VLTrainer.getUpdateListIntance()");
        }
        if (((VLTrainerUpdateListImpl) list).isEmpty()) {
            throw new IllegalArgumentException("list cannot be empty");
        }
        if (StringUtils.isNullOrWhiteSpace(language)) {
            throw new IllegalArgumentException("language cannot be null or empty");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must be specifed");
        }
        if (isBusy()) {
            throw new IllegalStateException("Trainer request already in progress");
        }
        setBusy(true);
        this.mTrainerListener = listener;
        getHandler().post(new Runnable() { // from class: com.vlingo.sdk.internal.VLTrainerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                List<LMTTItem> lmttItemList = ((VLTrainerUpdateListImpl) list).compact();
                VLHttpServiceRequest request = LMTTComm.createLMTTRequest(lmttItemList, doWhole, language, VLTrainerImpl.this);
                request.schedule(0L, true, true);
            }
        });
    }

    private static HashMap<VLTrainer.TrainerItemType, Integer> lmttType2TrainerType(HashMap<LMTTItem.LmttItemType, Integer> lmttCounts) {
        if (lmttCounts == null) {
            return null;
        }
        HashMap<VLTrainer.TrainerItemType, Integer> trainerCounts = new HashMap<>(lmttCounts.size());
        for (LMTTItem.LmttItemType lmttType : lmttCounts.keySet()) {
            switch ($SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType()[lmttType.ordinal()]) {
                case 1:
                    trainerCounts.put(VLTrainer.TrainerItemType.CONTACT, lmttCounts.get(lmttType));
                    break;
                case 2:
                    trainerCounts.put(VLTrainer.TrainerItemType.SONG, lmttCounts.get(lmttType));
                    break;
                case 3:
                    trainerCounts.put(VLTrainer.TrainerItemType.PLAYLIST, lmttCounts.get(lmttType));
                    break;
            }
        }
        return trainerCounts;
    }
}
