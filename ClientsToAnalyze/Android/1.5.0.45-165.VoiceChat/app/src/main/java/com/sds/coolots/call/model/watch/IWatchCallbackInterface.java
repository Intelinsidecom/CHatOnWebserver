package com.sds.coolots.call.model.watch;

import com.sds.coolots.call.model.Destination;

/* loaded from: classes.dex */
public interface IWatchCallbackInterface {
    void NotifyCallConnected(Destination destination);

    void NotifyCallDisconnected(Destination destination, int i);

    void NotifyConfCallOutFromPhone(Destination destination, boolean z);

    void NotifyConferenceCallRinging(Destination destination, boolean z);

    void NotifyHoldStateToWatch(Destination destination, boolean z);

    void NotifyMuteStateToWatch(Destination destination, boolean z);

    void NotifyP2PCallOutFromPhone(Destination destination, boolean z);

    void NotifyP2PCallRinging(Destination destination, boolean z);

    boolean isCallReceiveFromWatch();

    void notifyChangeCallType(Destination destination, boolean z);

    void notifyChangeConfToP2PCall(Destination destination, boolean z);

    void notifyChangeP2PToConfCall(Destination destination, boolean z);

    void notifyStopRingtone(Destination destination);

    void notifyUpdateConferenceMember(Destination destination, boolean z);

    void setCallReceiveFromWatch(boolean z);
}
